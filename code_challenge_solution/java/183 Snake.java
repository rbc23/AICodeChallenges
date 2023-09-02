```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class SnakeClone extends JPanel implements KeyListener {

    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    private final int UNIT_SIZE = 25;
    private final int GAME_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    private final int DELAY = 75;

    private final int[] x = new int[GAME_UNITS];
    private final int[] y = new int[GAME_UNITS];
    private int bodyParts;

    private int appleX;
    private int appleY;

    private char direction = 'R';

    private boolean running = false;
    private Timer timer;

    public SnakeClone() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        startGame();
    }

    private void startGame() {
        generateApple();
        running = true;
        bodyParts = 1;
        x[0] = WIDTH / 2;
        y[0] = HEIGHT / 2;
        timer = new Timer(DELAY, e -> gameLoop());
        timer.start();
    }

    private void gameLoop() {
        move();
        checkCollision();
        checkAppleCollision();
        repaint();
    }

    private void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U' -> y[0] -= UNIT_SIZE;
            case 'D' -> y[0] += UNIT_SIZE;
            case 'L' -> x[0] -= UNIT_SIZE;
            case 'R' -> x[0] += UNIT_SIZE;
        }
    }

    private void checkCollision() {
        // Check if snake head collides with body parts
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
                timer.stop();
            }
        }

        // Check if snake collides with walls
        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            running = false;
            timer.stop();
        }
    }

    private void checkAppleCollision() {
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            generateApple();
        }
    }

    private void generateApple() {
        Random random = new Random();
        appleX = random.nextInt((WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }

    private void draw(Graphics graphics) {
        if (running) {
            graphics.setColor(Color.RED);
            graphics.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    graphics.setColor(Color.GREEN);
                } else {
                    graphics.setColor(new Color(45, 180, 0));
                }
                graphics.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }

            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: " + (bodyParts - 1), (WIDTH - metrics.stringWidth("Score: " + (bodyParts - 1))) / 2, graphics.getFont().getSize());
        } else {
            gameOver(graphics);
        }
    }

    private void gameOver(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over", (WIDTH - metrics.stringWidth("Game Over")) / 2, HEIGHT / 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && direction != 'D') {
            direction = 'U';
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && direction != 'U') {
            direction = 'D';
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && direction != 'R') {
            direction = 'L';
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && direction != 'L') {
            direction = 'R';
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Clone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new SnakeClone());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
```