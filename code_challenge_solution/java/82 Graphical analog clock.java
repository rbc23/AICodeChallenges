import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class AnalogClockGUI extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        int clockRadius = (int) (Math.min(width, height) * 0.4);
        int xCenter = width / 2;
        int yCenter = height / 2;

        // Draw clock circle
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);

        // Draw hour hand
        g2d.setStroke(new BasicStroke(5));
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        int second = Calendar.getInstance().get(Calendar.SECOND);
        int hourHandLength = (int) (clockRadius * 0.5);
        int hourHandX = (int) (xCenter + hourHandLength * Math.sin(Math.toRadians((hour * 30) + (minute * 0.5))));
        int hourHandY = (int) (yCenter - hourHandLength * Math.cos(Math.toRadians((hour * 30) + (minute * 0.5))));
        g2d.drawLine(xCenter, yCenter, hourHandX, hourHandY);

        // Draw minute hand
        g2d.setStroke(new BasicStroke(3));
        int minuteHandLength = (int) (clockRadius * 0.7);
        int minuteHandX = (int) (xCenter + minuteHandLength * Math.sin(Math.toRadians((minute * 6) + (second * 0.1))));
        int minuteHandY = (int) (yCenter - minuteHandLength * Math.cos(Math.toRadians((minute * 6) + (second * 0.1))));
        g2d.drawLine(xCenter, yCenter, minuteHandX, minuteHandY);

        // Draw second hand
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(1));
        int secondHandLength = (int) (clockRadius * 0.9);
        int secondHandX = (int) (xCenter + secondHandLength * Math.sin(Math.toRadians(second * 6)));
        int secondHandY = (int) (yCenter - secondHandLength * Math.cos(Math.toRadians(second * 6)));
        g2d.drawLine(xCenter, yCenter, secondHandX, secondHandY);

        // Draw center dot
        g2d.setColor(Color.BLACK);
        int dotRadius = 5;
        g2d.fillOval(xCenter - dotRadius, yCenter - dotRadius, 2 * dotRadius, 2 * dotRadius);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Analog Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AnalogClockGUI clockGUI = new AnalogClockGUI();
        frame.add(clockGUI);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
