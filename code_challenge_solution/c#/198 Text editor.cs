using System;
using System.IO;

class TextEditor
{
    static void Main()
    {
        Console.WriteLine("Welcome to the Text Editor!");
        Console.WriteLine("Please enter the file name: ");
        string fileName = Console.ReadLine();

        if (File.Exists(fileName))
        {
            Console.WriteLine("File already exists.");
            Console.WriteLine("Please enter the content to append: ");
            string content = Console.ReadLine();

            using (StreamWriter sw = File.AppendText(fileName))
            {
                sw.WriteLine(content);
            }
            
            Console.WriteLine("Content appended successfully.");
        }
        else
        {
            Console.WriteLine("File does not exist.");
            Console.WriteLine("Please enter the content to write: ");
            string content = Console.ReadLine();

            using (StreamWriter sw = File.CreateText(fileName))
            {
                sw.WriteLine(content);
            }

            Console.WriteLine("Content written successfully.");
        }
    }
}