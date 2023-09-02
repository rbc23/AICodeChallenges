string[] digits = {
    "###   ###  #     ###  ###  ###  ###  ###  ###",
    "# #   # #  #     #      #    #    #    #  #",
    "# #   # #  #     ###  ###  ###  ###  ###  ###",
    "# #   # #  #     #    #      #  #  #    #  #",
    "###   ###  ###   ###  ###    #  ###  ###  ###"
};

void DrawDigit(int digit, int x, int y)
{
    var lines = digits[digit].Split('\n');
    
    for (int i = 0; i < lines.Length; i++)
    {
        Console.SetCursorPosition(x, y + i);
        Console.Write(lines[i]);
    }
}

void DrawClock(int hours, int minutes, int seconds)
{
    Console.Clear();
    
    if (hours < 10)
    {
        DrawDigit(0, 0, 0);
        DrawDigit(hours, 5, 0);
    }
    else
    {
        DrawDigit(hours / 10, 0, 0);
        DrawDigit(hours % 10, 5, 0);
    }
    
    DrawDigit(10, 10, 0); // Colon
    
    if (minutes < 10)
    {
        DrawDigit(0, 14, 0);
        DrawDigit(minutes, 19, 0);
    }
    else
    {
        DrawDigit(minutes / 10, 14, 0);
        DrawDigit(minutes % 10, 19, 0);
    }
    
    DrawDigit(10, 23, 0); // Colon
    
    if (seconds < 10)
    {
        DrawDigit(0, 27, 0);
        DrawDigit(seconds, 32, 0);
    }
    else
    {
        DrawDigit(seconds / 10, 27, 0);
        DrawDigit(seconds % 10, 32, 0);
    }
}

void Main()
{
    while (true)
    {
        DateTime now = DateTime.Now;
        int hours = now.Hour;
        int minutes = now.Minute;
        int seconds = now.Second;
        
        DrawClock(hours, minutes, seconds);
        System.Threading.Thread.Sleep(1000);
    }
}