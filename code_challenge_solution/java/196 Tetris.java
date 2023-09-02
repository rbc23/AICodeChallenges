import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tetris extends JPanel implements ActionListener {

    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 22;
    private final int DELAY = 300;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isStarted = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private Shape curPiece;
    private Shape.Tetrominoes[] board;
    
    public Tetris() {
        initBoard();
    }
    
    private void initBoard() {
        
        setFocusable(true);
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
    }
    
    private void start() {
        
        curPiece = new Shape();
        board = new Shape.Tetrominoes[BOARD_WIDTH * BOARD_HEIGHT];
        
        clearBoard();
        
        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        newPiece();
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void pause() {
        
        isPaused = !isPaused;
        
        if (isPaused) {
            
            timer.stop();
        } else {
            
            timer.start();
        }
        
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        var size = getSize();
        var boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();
        
        for (var i = 0; i < BOARD_HEIGHT; i++) {
            
            for (var j = 0; j < BOARD_WIDTH; j++) {
                
                var shape = shapeAt(j, BOARD_HEIGHT - i - 1);
                
                if (shape != Shape.Tetrominoes.NoShape) {
                    
                    drawSquare(g, j * squareWidth(),
                            boardTop + i * squareHeight(), shape);
                }
            }
        }
        
        if (curPiece.getShape() != Shape.Tetrominoes.NoShape) {
            
            for (var i = 0; i < 4; i++) {
                
                var x = curX + curPiece.x(i);
                var y = curY - curPiece.y(i);
                drawSquare(g, x * squareWidth(),
                        boardTop + (BOARD_HEIGHT - y - 1) * squareHeight(),
                        curPiece.getShape());
            }
        }
        
        if (isPaused) {
            
            var fm = g.getFontMetrics();
            g.setColor(Color.YELLOW);
            g.drawString("Paused", (int) ((size.getWidth() - fm.stringWidth("Paused")) / 2),
                    (int) size.getHeight() / 2);
        }
    }
    
    private void dropDown() {
        
        var newY = curY;
        
        while (newY > 0) {
            
            if (!tryMove(curPiece, curX, newY - 1)) {
                
                break;
            }
            
            newY--;
        }
        
        pieceDropped();
    }
    
    private void oneLineDown() {
        
        if (!tryMove(curPiece, curX, curY - 1)) {
            
            pieceDropped();
        }
    }
    
    private void clearBoard() {
        
        for (var i = 0; i < BOARD_HEIGHT * BOARD_WIDTH; i++) {
            
            board[i] = Shape.Tetrominoes.NoShape;
        }
    }
    
    private void pieceDropped() {
        
        for (var i = 0; i < 4; i++) {
            
            var x = curX + curPiece.x(i);
            var y = curY - curPiece.y(i);
            board[(y * BOARD_WIDTH) + x] = curPiece.getShape();
        }
        
        removeFullLines();
        
        if (!isFallingFinished) {
            
            newPiece();
        }
    }
    
    private void newPiece() {
        
        curPiece.setRandomShape();
        
        curX = BOARD_WIDTH / 2 + 1;
        curY = BOARD_HEIGHT - 1 + curPiece.minY();
        
        if (!tryMove(curPiece, curX, curY)) {
            
            curPiece.setShape(Shape.Tetrominoes.NoShape);
            timer.stop();
            isStarted = false;
        }
    }
    
    private boolean tryMove(Shape newPiece, int newX, int newY) {
        
        for (var i = 0; i < 4; i++) {
            
            var x = newX + newPiece.x(i);
            var y = newY - newPiece.y(i);
            
            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {
                
                return false;
            }
            
            if (shapeAt(x, y) != Shape.Tetrominoes.NoShape) {
                
                return false;
            }
        }
        
        curPiece = newPiece;
        curX = newX;
        curY = newY;
        
        repaint();
        
        return true;
    }
    
    private void removeFullLines() {
        
        var numFullLines = 0;
        
        for (var i = BOARD_HEIGHT - 1; i >= 0; i--) {
            
            var lineIsFull = true;
            
            for (var j = 0; j < BOARD_WIDTH; j++) {
                
                if (shapeAt(j, i) == Shape.Tetrominoes.NoShape) {
                    
                    lineIsFull = false;
                    break;
                }
            }
            
            if (lineIsFull) {
                
                numFullLines++;
                
                for (var k = i; k < BOARD_HEIGHT - 1; k++) {
                    for (var j = 0; j < BOARD_WIDTH; j++) {
                        
                        board[(k * BOARD_WIDTH) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }
        
        if (numFullLines > 0) {
            
            numLinesRemoved += numFullLines;
            isFallingFinished = true;
            
            curPiece.setShape(Shape.Tetrominoes.NoShape);
            repaint();
        }
    }
    
    private void drawSquare(Graphics g, int x, int y, Shape.Tetrominoes shape) {
        
        var colors = new Color[]{Color.BLACK, Color.CYAN, Color.YELLOW,
            Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.BLUE, Color.RED};
        
        var color = colors[shape.ordinal()];
        
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }
    
    private Shape.Tetrominoes shapeAt(int x, int y) {
        
        return board[(y * BOARD_WIDTH) + x];
    }

    private int squareWidth() {
        
        return (int) getSize().getWidth() / BOARD_WIDTH;
    }

    private int squareHeight() {
        
        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (isFallingFinished) {
            
            isFallingFinished = false;
            newPiece();
        } else {
            
            oneLineDown();
        }
    }
    
    private void gameOver() {
        
        var msg = "Game Over";
        
        var size = g.getFontMetrics().getStringBounds(msg, g).getSize();
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 36));
        g.drawString(msg, (int) ((getSize().getWidth() - size.getWidth()) / 2),
                (int) (getSize().getHeight() / 2));
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            
            if (!isStarted || curPiece.getShape() == Shape.Tetrominoes.NoShape) {
                
                return;
            }
            
            int keycode = e.getKeyCode();
            
            if (keycode == 'P') {
                
                pause();
                return;
            }
            
            if (isPaused) {
                
                return;
            }
            
            switch (keycode) {
                
                case KeyEvent.VK_LEFT:
                    tryMove(curPiece, curX - 1, curY);
                    break;
                    
                case KeyEvent.VK_RIGHT:
                    tryMove(curPiece, curX + 1, curY);
                    break;
                    
                case KeyEvent.VK_DOWN:
                    oneLineDown();
                    break;
                    
                case KeyEvent.VK_UP:
                    tryMove(curPiece.rotateRight(), curX, curY);
                    break;
                    
                case KeyEvent.VK_SPACE:
                    dropDown();
                    break;
            }
        }
    }
}
