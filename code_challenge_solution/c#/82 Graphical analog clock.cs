Sure! Here is a C# code to create a graphical analog clock GUI:

```csharp
using System;
using System.Drawing;
using System.Windows.Forms;

public class AnalogClock : Form
{
    private Timer timer;

    public AnalogClock()
    {
        this.timer = new Timer();
        this.timer.Interval = 1000;
        this.timer.Tick += Timer_Tick;
        this.timer.Start();
        
        this.DoubleBuffered = true;
        this.BackColor = Color.Black;
        this.ClientSize = new Size(400, 400);
        this.Paint += AnalogClock_Paint;
    }

    private void Timer_Tick(object sender, EventArgs e)
    {
        this.Invalidate();
    }

    private void AnalogClock_Paint(object sender, PaintEventArgs e)
    {
        Graphics g = e.Graphics;
        int centerX = this.ClientSize.Width / 2;
        int centerY = this.ClientSize.Height / 2;
        int radius = Math.Min(centerX, centerY) - 10;
        int secLength = radius;
        int minLength = radius - 20;
        int hourLength = radius - 40;

        DateTime currentTime = DateTime.Now;
        int second = currentTime.Second;
        int minute = currentTime.Minute;
        int hour = currentTime.Hour;

        int secondAngle = (second * 6) - 90;
        int minuteAngle = (minute * 6) - 90;
        int hourAngle = (hour * 30) + (minute / 2) - 90;

        Pen hourPen = new Pen(Color.White, 4);
        Pen minutePen = new Pen(Color.White, 3);
        Pen secondPen = new Pen(Color.Red, 2);

        g.TranslateTransform(centerX, centerY);
        g.RotateTransform(hourAngle);
        g.DrawLine(hourPen, 0, 0, 0, -hourLength);

        g.ResetTransform();
        g.TranslateTransform(centerX, centerY);
        g.RotateTransform(minuteAngle);
        g.DrawLine(minutePen, 0, 0, 0, -minLength);

        g.ResetTransform();
        g.TranslateTransform(centerX, centerY);
        g.RotateTransform(secondAngle);
        g.DrawLine(secondPen, 0, 0, 0, -secLength);
    }

    public static void Main()
    {
        Application.Run(new AnalogClock());
    }
}
```

This code creates a form window with a black background and a size of 400x400 pixels. It uses the `Paint` event handler to draw the clock hands on the form's surface. The `Timer` object is used to update the clock every second by calling `Invalidate` method. The `AnalogClock_Paint` method calculates the angles for the hour, minute, and second hands based on the current time, and then uses the `Graphics` object to draw the lines representing the clock hands. Finally, the `Main` method starts the application by running the `AnalogClock` form.