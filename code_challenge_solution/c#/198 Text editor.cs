using System;
using System.IO;

class Program
{
    static void Main()
    {
        Console.WriteLine("Enter the file name:");
        string fileName = Console.ReadLine();

        Console.WriteLine("Enter the text:");
        string text = Console.ReadLine();

        try
        {
            // Create or open the file
            using (StreamWriter writer = File.CreateText(fileName))
            {
                // Write the text to the file
                writer.Write(text);
            }

            Console.WriteLine("Text saved successfully!");
        }
        catch (Exception ex)
        {
            Console.WriteLine("An error occurred: " + ex.Message);
        }
    }
}