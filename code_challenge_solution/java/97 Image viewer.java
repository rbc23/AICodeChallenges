
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageViewer extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JButton prevButton;
    private JButton nextButton;
    private int currentImageIndex;
    private String[] imagePaths;

    public ImageViewer() {
        super("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        imageLabel = new JLabel();
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");

        prevButton.addActionListener(this);
        nextButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(imageLabel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(contentPanel);

        currentImageIndex = 0;
        imagePaths = new String[]{"path/to/image1.jpg", "path/to/image2.jpg", "path/to/image3.jpg"};

        showImage();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == prevButton) {
            currentImageIndex--;
            if (currentImageIndex < 0) {
                currentImageIndex = imagePaths.length - 1;
            }
        } else if (source == nextButton) {
            currentImageIndex++;
            if (currentImageIndex >= imagePaths.length) {
                currentImageIndex = 0;
            }
        }

        showImage();
    }

    private void showImage() {
        String imagePath = imagePaths[currentImageIndex];
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            Image scaledImage = image.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageViewer();
            }
        });
    }
}
