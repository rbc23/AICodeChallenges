using System;
using System.Drawing;
using System.Windows.Forms;

namespace AnalogClock
{
    public partial class MainForm : Form
    {
        private Timer timer = new Timer();
        
        public MainForm()
        {
            InitializeComponent();
            
            // Set the form properties
            this.Text = "Analog Clock";
            this.BackColor = Color.White;
            this.DoubleBuffered = true;
            this.FormBorderStyle = FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Size = new Size(300, 300);
            
            // Set the timer properties
            timer.Interval = 1000; // Update every 1 second
            timer.Tick += new EventHandler(timer_Tick);
            timer.Start();
        }
        
        private void timer_Tick(object sender, EventArgs e)
        {
            // Redraw the form every tick
            this.Invalidate();
        }
        
        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            
            Graphics g = e.Graphics;
            int centerX = this.ClientSize.Width / 2;
            int centerY = this.ClientSize.Height / 2;
            int radius = Math.Min(centerX, centerY) - 10;
            
            // Draw the clock outline
            g.DrawEllipse(Pens.Black, centerX - radius, centerY - radius, radius * 2, radius * 2);
            
            // Draw the hour hand
            DateTime now = DateTime.Now;
            int hour = now.Hour % 12;
            int minute = now.Minute;
            double hourAngle = (hour * 30) + (minute * 0.5);
            double hourX = centerX + (radius * 0.6 * Math.Sin(hourAngle * Math.PI / 180));
            double hourY = centerY - (radius * 0.6 * Math.Cos(hourAngle * Math.PI / 180));
            g.DrawLine(Pens.Black, centerX, centerY, (float)hourX, (float)hourY);
            
            // Draw the minute hand
            double minuteAngle = minute * 6;
            double minuteX = centerX + (radius * 0.8 * Math.Sin(minuteAngle * Math.PI / 180));
            double minuteY = centerY - (radius * 0.8 * Math.Cos(minuteAngle * Math.PI / 180));
            g.DrawLine(Pens.Black, centerX, centerY, (float)minuteX, (float)minuteY);
            
            // Draw the second hand
            int second = now.Second;
            double secondAngle = second * 6;
            double secondX = centerX + (radius * 0.9 * Math.Sin(secondAngle * Math.PI / 180));
            double secondY = centerY - (radius * 0.9 * Math.Cos(secondAngle * Math.PI / 180));
            g.DrawLine(Pens.Red, centerX, centerY, (float)secondX, (float)secondY);
            
            // Draw the center point
            g.FillEllipse(Brushes.Black, centerX - 2, centerY - 2, 4, 4);
        }
        
        static void Main()
        {
            Application.Run(new MainForm());
        }
    }
}