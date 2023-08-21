import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlappyBird extends JFrame {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int GROUND_HEIGHT = 100;
    private final int PIPE_WIDTH = 100;
    private final int PIPE_HEIGHT = 300;
    private final int PIPE_GAP = 200;
    private final int BIRD_SIZE = 40;
    private final int BIRD_START_X = WIDTH / 2 - BIRD_SIZE / 2;
    private final int BIRD_START_Y = HEIGHT / 2 - BIRD_SIZE / 2;
    private final int GRAVITY = 2;
    private final int JUMP = 20;

    private BufferedImage backBuffer;
    private Image backgroundImage;
    private Image birdImage;
    private Image pipeImage;

    private int birdX;
    private int birdY;
    private int birdYMotion;

    private List<Pipe> pipes;

    private boolean isRunning = true;
    private boolean isStarted = false;
    private int score = 0;

    public FlappyBird() {
        setTitle("Flappy Bird");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        backBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        backgroundImage = new ImageIcon(getClass().getResource("background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("bird.png")).getImage();
        pipeImage = new ImageIcon(getClass().getResource("pipe.png")).getImage();

        birdX = BIRD_START_X;
        birdY = BIRD_START_Y;

        pipes = new ArrayList<>();

        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!isStarted)
                    isStarted = true;
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    birdYMotion = -JUMP;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        });

        setVisible(true);
        start();
    }

    private void start() {
        while (isRunning) {
            update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            render();
        }
    }

    private void update() {
        if (isStarted) {
            birdYMotion += GRAVITY;
            birdY += birdYMotion;

            if (birdY <= 0 || birdY + BIRD_SIZE > HEIGHT - GROUND_HEIGHT) {
                gameOver();
            }

            for (Pipe pipe : pipes) {
                if (pipe.getX() == BIRD_START_X) {
                    score++;
                }
                
                if (birdX + BIRD_SIZE > pipe.getX() && birdX < pipe.getX() + PIPE_WIDTH) {
                    if (birdY < pipe.getTopHeight() || birdY + BIRD_SIZE > pipe.getBottomHeight()) {
                        gameOver();
                    }
                }

                if (pipe.getX() + PIPE_WIDTH < 0) {
                    pipes.remove(pipe);
                    break;
                }

                pipe.update();
            }

            if (pipes.isEmpty()) {
                pipes.add(new Pipe(WIDTH + PIPE_WIDTH));
            }
        }
    }

    private void render() {
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        bbg.drawImage(backgroundImage, 0, 0, null);

        if (isStarted) {
            for (Pipe pipe : pipes) {
                bbg.drawImage(pipeImage, pipe.getX(), 0, PIPE_WIDTH, pipe.getTopHeight(), null);
                bbg.drawImage(pipeImage, pipe.getX(), HEIGHT - GROUND_HEIGHT - pipe.getBottomHeight(),
                        PIPE_WIDTH, pipe.getBottomHeight(), null);
            }
            bbg.drawImage(birdImage, birdX, birdY, BIRD_SIZE, BIRD_SIZE, null);

            bbg.setColor(Color.WHITE);
            bbg.setFont(new Font("Arial", Font.BOLD, 20));
            bbg.drawString("Score: " + score, 10, 30);
        } else {
            bbg.setColor(Color.WHITE);
            bbg.setFont(new Font("Arial", Font.BOLD, 40));
            bbg.drawString("Press SPACE to Start", 200, HEIGHT / 2);
        }

        g.drawImage(backBuffer, 0, 0, null);
    }

    private void gameOver() {
        isRunning = false;
    }

    private class Pipe {
        private int x;
        private int topHeight;
        private int bottomHeight;

        public Pipe(int x) {
            this.x = x;
            this.topHeight = new Random().nextInt(PIPE_HEIGHT - PIPE_GAP) + PIPE_GAP / 2;
            this.bottomHeight = PIPE_HEIGHT - topHeight;
        }

        public int getX() {
            return x;
        }
        
        public int getTopHeight() {
            return topHeight;
        }
        
        public int getBottomHeight() {
            return bottomHeight;
        }
        
        public void update() {
            x--;

            if (x + PIPE_WIDTH == BIRD_START_X)
                score++;
        }
    }

    public static void main(String[] args) {
        new FlappyBird();
    }
}

