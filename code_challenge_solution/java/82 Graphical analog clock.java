```java
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class AnalogClock extends JPanel {

    private static final int CLOCK_RADIUS = 200;
    private static final int HOUR_HAND_LENGTH = 70;
    private static final int MINUTE_HAND_LENGTH = 90;
    private static final int SECOND_HAND_LENGTH = 95;
    private static final int HAND_WIDTH = 4;

    public AnalogClock() {
        setPreferredSize(new Dimension(CLOCK_RADIUS * 2, CLOCK_RADIUS * 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        drawClockCircle(g, centerX, centerY);
        drawHourHand(g, centerX, centerY);
        drawMinuteHand(g, centerX, centerY);
        drawSecondHand(g, centerX, centerY);
    }

    private void drawClockCircle(Graphics g, int centerX, int centerY) {
        g.setColor(Color.BLACK);
        g.drawOval(centerX - CLOCK_RADIUS, centerY - CLOCK_RADIUS, CLOCK_RADIUS * 2, CLOCK_RADIUS * 2);
    }

    private void drawHand(Graphics g, int centerX, int centerY, double angle, int handLength, int handWidth) {
        int handX = (int) (centerX + Math.sin(angle) * handLength);
        int handY = (int) (centerY - Math.cos(angle) * handLength);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(handWidth));
        g.drawLine(centerX, centerY, handX, handY);
    }

    private void drawHourHand(Graphics g, int centerX, int centerY) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        double angle = Math.toRadians((hour * 30) - 90);
        drawHand(g, centerX, centerY, angle, HOUR_HAND_LENGTH, HAND_WIDTH);
    }

    private void drawMinuteHand(Graphics g, int centerX, int centerY) {
        Calendar calendar = Calendar.getInstance();
        int minute = calendar.get(Calendar.MINUTE);
        double angle = Math.toRadians((minute * 6) - 90);
        drawHand(g, centerX, centerY, angle, MINUTE_HAND_LENGTH, HAND_WIDTH);
    }

    private void drawSecondHand(Graphics g, int centerX, int centerY) {
        Calendar calendar = Calendar.getInstance();
        int second = calendar.get(Calendar.SECOND);
        double angle = Math.toRadians((second * 6) - 90);
        drawHand(g, centerX, centerY, angle, SECOND_HAND_LENGTH, HAND_WIDTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Analog Clock");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new AnalogClock());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
```