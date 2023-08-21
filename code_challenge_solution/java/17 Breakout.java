import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends JFrame {
    private BreakoutPanel gamePanel;
    
    public Breakout() {
        setTitle("Breakout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        gamePanel = new BreakoutPanel();
        
        add(gamePanel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Breakout();
            }
        });
    }
}

class BreakoutPanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int paddleX;
    private int ballX, ballY;
    private int ballDeltaX, ballDeltaY;
    private boolean ballMove;
    
    public BreakoutPanel() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(400, 300));
        
        addKeyListener(this);
        setFocusable(true);
        
        timer = new Timer(5, this);
        
        paddleX = 150;
        
        ballX = 190;
        ballY = 200;
        ballDeltaX = 1;
        ballDeltaY = 1;
        
        ballMove = false;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillRect(paddleX, 280, 60, 10);
        
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, 10, 10);
        
        if (!ballMove) {
            g.setColor(Color.GREEN);
            g.drawString("Press Space to Start", 160, 150);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        ballX += ballDeltaX;
        ballY += ballDeltaY;
        
        if (ballX >= paddleX && ballX <= paddleX + 60 && ballY >= 270 && ballY <= 290) {
            ballDeltaY *= -1;
        }
        
        if (ballX < 0 || ballX > 390) {
            ballDeltaX *= -1;
        }
        
        if (ballY < 0 || ballY > 290) {
            ballDeltaY *= -1;
        }
        
        repaint();
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddleX += 10;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddleX -= 10;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!ballMove) {
                ballMove = true;
                timer.start();
            }
        }
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
