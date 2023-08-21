import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimonClone extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel gamePanel;
    private JButton[] buttons;
    private JButton startButton;
    private JLabel scoreLabel;
    private int[] sequence;
    private int sequenceIndex;
    private int playerIndex;
    private int score;
    private boolean gameRunning;

    public SimonClone() {
        setTitle("Simon Clone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(2, 2));

        buttons = new JButton[4];
        buttons[0] = createButton(Color.RED);
        buttons[1] = createButton(Color.GREEN);
        buttons[2] = createButton(Color.BLUE);
        buttons[3] = createButton(Color.YELLOW);

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        scoreLabel = new JLabel("Score: 0");

        add(gamePanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.NORTH);
        add(scoreLabel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createButton(Color color) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setOpaque(true);
        button.setEnabled(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (gameRunning) {
                    if (sequence[playerIndex] == getColorIndex(button)) {
                        playerIndex++;
                    } else {
                        gameOver();
                    }

                    if (playerIndex == sequenceIndex) {
                        playerIndex = 0;
                        score++;
                        scoreLabel.setText("Score: " + score);
                        playSequence();
                    }
                }
            }
        });
        gamePanel.add(button);
        return button;
    }

    private int getColorIndex(JButton button) {
        for (int i = 0; i < buttons.length; i++) {
            if (button == buttons[i]) {
                return i;
            }
        }
        return -1;
    }

    private void startGame() {
        startButton.setEnabled(false);
        score = 0;
        scoreLabel.setText("Score: " + score);
        sequence = new int[20];
        playSequence();
    }

    private void playSequence() {
        gameRunning = false;
        sequenceIndex++;
        sequence[sequenceIndex - 1] = (int) (Math.random() * 4);
        Timer timer = new Timer(1000, new ActionListener() {
            private int index = 0;

            public void actionPerformed(ActionEvent e) {
                if (index < sequenceIndex) {
                    buttons[sequence[index]].setEnabled(true);
                    buttons[sequence[index]].repaint();
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                    gameRunning = true;
                    playerIndex = 0;
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    private void gameOver() {
        gameRunning = false;
        startButton.setEnabled(true);
        sequenceIndex = 0;
        playerIndex = 0;
        JOptionPane.showMessageDialog(null, "Game Over! Your Score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimonClone();
            }
        });
    }
}