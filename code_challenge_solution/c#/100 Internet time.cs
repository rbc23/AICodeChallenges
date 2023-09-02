using System;

class Program
{
    static void Main()
    {
        DateTime currentTime = DateTime.Now;
        int internetTime = GetInternetTime(currentTime);
        Console.WriteLine($"Current Internet Time: {internetTime}");

        //Wait for user input before closing console window
        Console.ReadLine();
    }

    static int GetInternetTime(DateTime time)
    {
        int swatchTime = (time.Second + (time.Minute * 60) + (time.Hour * 3600)) * 1000 / 86400;
        return swatchTime;
    }
}