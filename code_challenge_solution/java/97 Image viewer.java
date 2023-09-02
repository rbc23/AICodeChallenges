import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageViewer extends JFrame {
    private JLabel imageLabel;
    private JButton previousButton;
    private JButton nextButton;

    private String[] imagePaths;
    private int currentImageIndex;

    public ImageViewer(String[] imagePaths) {
        this.imagePaths = imagePaths;
        this.currentImageIndex = 0;

        initializeComponents();
        setupLayout();

        displayImage();
    }

    private void initializeComponents() {
        imageLabel = new JLabel();
        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
    }

    private void setupLayout() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);

        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayImage() {
        ImageIcon imageIcon = new ImageIcon(imagePaths[currentImageIndex]);
        Image image = imageIcon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
    }

    private void showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--;
        } else {
            currentImageIndex = imagePaths.length - 1;
        }
        displayImage();
    }

    private void showNextImage() {
        if (currentImageIndex < imagePaths.length - 1) {
            currentImageIndex++;
        } else {
            currentImageIndex = 0;
        }
        displayImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[] imagePaths = { "image1.jpg", "image2.jpg", "image3.jpg" };
                new ImageViewer(imagePaths);
            }
        });
    }
}
