import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnalogClockGUI extends JPanel {
    private int centerX;
    private int centerY;

    public AnalogClockGUI() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Set background color
        setBackground(Color.BLACK);

        // Enable anti-aliasing for smoother rendering
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Get current time
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        // Calculate angle for each hand
        double hourAngle = Math.toRadians((hours % 12) * 30 + 0.5 * minutes);
        double minuteAngle = Math.toRadians((minutes % 60) * 6 + 0.1 * seconds);
        double secondAngle = Math.toRadians(seconds * 6);

        // Calculate hand lengths
        int hourHandLength = (int) (getSize().width * 0.30);
        int minuteHandLength = (int) (getSize().width * 0.40);
        int secondHandLength = (int) (getSize().width * 0.45);

        // Calculate hand end points
        int hourHandEndX = (int) (centerX + hourHandLength * Math.sin(hourAngle));
        int hourHandEndY = (int) (centerY - hourHandLength * Math.cos(hourAngle));
        int minuteHandEndX = (int) (centerX + minuteHandLength * Math.sin(minuteAngle));
        int minuteHandEndY = (int) (centerY - minuteHandLength * Math.cos(minuteAngle));
        int secondHandEndX = (int) (centerX + secondHandLength * Math.sin(secondAngle));
        int secondHandEndY = (int) (centerY - secondHandLength * Math.cos(secondAngle));

        // Draw clock frame
        g2.setColor(Color.WHITE);
        g2.fillOval(centerX - 150, centerY - 150, 300, 300);

        // Draw hour hand
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(centerX, centerY, hourHandEndX, hourHandEndY);

        // Draw minute hand
        g2.setColor(Color.GREEN);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(centerX, centerY, minuteHandEndX, minuteHandEndY);

        // Draw second hand
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(centerX, centerY, secondHandEndX, secondHandEndY);

        // Draw clock center
        g2.setColor(Color.WHITE);
        g2.fillOval(centerX - 10, centerY - 10, 20, 20);

        // Draw numerals
        g2.setFont(new Font("Arial", Font.BOLD, 12));
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians((i * 30) - 60);
            int x = (int) (centerX + 130 * Math.sin(angle));
            int y = (int) (centerY - 130 * Math.cos(angle));
            g2.drawString(Integer.toString(i), x, y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Analog Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        AnalogClockGUI clock = new AnalogClockGUI();
        frame.add(clock);

        // Center the clock on the panel
        clock.centerX = clock.getWidth() / 2;
        clock.centerY = clock.getHeight() / 2;

        frame.setVisible(true);
    }
}