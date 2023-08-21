using System;
using System.Threading;

class ASCIIDigitalClock
{
    static void Main()
    {
        while (true)
        {
            Console.Clear();
            Console.WriteLine(DateTime.Now.ToString("HH:mm:ss"));
            Thread.Sleep(1000);
        }
    }
}
