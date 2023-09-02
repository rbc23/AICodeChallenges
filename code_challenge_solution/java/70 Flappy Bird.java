import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyBirdClone extends JPanel implements ActionListener {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int PIPE_WIDTH = 80;
    private static final int PIPE_HEIGHT = 400;
    private static final int PIPE_GAP = 200;
    private static final int BIRD_SIZE = 50;
    private static final int BIRD_INIT_POS_X = 100;
    private static final int BIRD_INIT_POS_Y = HEIGHT / 2;
    private static final int BIRD_FALL_SPEED = 5;
    private static final int BIRD_JUMP_SPEED = 7;

    private Image backgroundImg;
    private Image birdImg;
    private Image pipeImg;
    private Bird bird;
    private List<Pipe> pipes;
    private Timer timer;
    private boolean isGameOver;

    public FlappyBirdClone() {
        JFrame frame = new JFrame("Flappy Bird Clone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    bird.jump();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER && isGameOver) {
                    resetGame();
                }
            }
        });

        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/background.png"));
        backgroundImg = icon.getImage();
        icon = new ImageIcon(getClass().getResource("/resources/bird.png"));
        birdImg = icon.getImage();
        icon = new ImageIcon(getClass().getResource("/resources/pipe.png"));
        pipeImg = icon.getImage();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        bird = new Bird(BIRD_INIT_POS_X, BIRD_INIT_POS_Y, birdImg.getHeight(null), birdImg.getWidth(null));
        pipes = new ArrayList<>();

        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImg, 0, 0, this);

        if (isGameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 24));
            g.drawString("Game Over!", WIDTH / 2 - 80, HEIGHT / 2);
            g.drawString("Press Enter to Play Again", WIDTH / 2 - 150, HEIGHT / 2 + 40);
        }

        if (!isGameOver) {
            bird.draw(g);

            for (Pipe pipe : pipes) {
                pipe.draw(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            bird.fall();

            for (Pipe pipe : pipes) {
                pipe.move();
                if (pipe.collidesWith(bird)) {
                    isGameOver = true;
                }
                if (!pipe.isPassed() && pipe.getX() + pipe.getWidth() < bird.getX()) {
                    pipe.setPassed(true);
                }
            }

            if (bird.getY() >= HEIGHT || bird.getY() + bird.getHeight() <= 0) {
                isGameOver = true;
            }

            if (!pipes.isEmpty() && pipes.get(0).getX() + pipes.get(0).getWidth() <= 0) {
                pipes.remove(0);
            }

            if (pipes.isEmpty() || pipes.get(pipes.size() - 1).getX() + PIPE_GAP < WIDTH) {
                addPipe();
            }

            repaint();
        }
    }

    private void addPipe() {
        int pipeX = WIDTH;
        int pipeY = (int) (Math.random() * (HEIGHT - PIPE_GAP - PIPE_HEIGHT));
        int upperPipeHeight = pipeY;
        int lowerPipeHeight = HEIGHT - pipeY - PIPE_GAP;
        pipes.add(new Pipe(pipeX, 0, PIPE_WIDTH, upperPipeHeight, pipeImg));
        pipes.add(new Pipe(pipeX, HEIGHT - lowerPipeHeight, PIPE_WIDTH, lowerPipeHeight, pipeImg));
    }

    private void resetGame() {
        bird = new Bird(BIRD_INIT_POS_X, BIRD_INIT_POS_Y, birdImg.getHeight(null), birdImg.getWidth(null));
        pipes = new ArrayList<>();
        isGameOver = false;
    }

    private class Bird extends Rectangle {

        private int velocity;

        public Bird(int x, int y, int height, int width) {
            super(x, y, width, height);
            velocity = BIRD_FALL_SPEED;
        }

        public void jump() {
            velocity = -BIRD_JUMP_SPEED;
        }

        public void fall() {
            if (getY() < HEIGHT - getHeight()) {
                velocity += BIRD_FALL_SPEED;
            }
            setLocation(getX(), getY() + velocity);
        }

        public void draw(Graphics g) {
            g.drawImage(birdImg, getX(), getY(), this);
        }

    }

    private class Pipe extends Rectangle {

        private boolean passed;

        public Pipe(int x, int y, int width, int height, Image image) {
            super(x, y, width, height);
            passed = false;
        }

        public boolean isPassed() {
            return passed;
        }

        public void setPassed(boolean passed) {
            this.passed = passed;
        }

        public void move() {
            setLocation(getX() - 2, getY());
        }

        public boolean collidesWith(Bird bird) {
            return intersects(bird);
        }

        public void draw(Graphics g) {
            g.drawImage(pipeImg, getX(), getY(), getWidth(), getHeight(), this);
        }

    }

    public static void main(String[] args) {
        new FlappyBirdClone();
    }

}
