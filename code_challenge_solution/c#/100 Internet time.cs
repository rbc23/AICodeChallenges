using System;

class Program
{
    static void Main(string[] args)
    {
        DateTime currentTime = DateTime.Now;
        int swatchInternetTime = ConvertToSwatchInternetTime(currentTime);
        Console.WriteLine("The current Swatch Internet Time is: " + swatchInternetTime);
    }

    static int ConvertToSwatchInternetTime(DateTime time)
    {
        int totalMilliseconds = (time.Hour * 3600000) + (time.Minute * 60000) + (time.Second * 1000) + time.Millisecond;
        int beats = (totalMilliseconds * 1000) / 86400000;
        if (beats >= 1000)
        {
            beats %= 1000;
        }
        return beats;
    }
}