using System;

namespace TextToHexBinaryConverter
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the text: ");
            string input = Console.ReadLine();

            Console.WriteLine("\nText to Hexadecimal conversion: ");
            string hexadecimal = ConvertTextToHex(input);
            Console.WriteLine(hexadecimal);

            Console.WriteLine("\nText to Binary conversion: ");
            string binary = ConvertTextToBinary(input);
            Console.WriteLine(binary);

            Console.ReadLine();
        }

        static string ConvertTextToHex(string text)
        {
            string hexadecimal = string.Empty;
            foreach (char c in text)
            {
                hexadecimal += String.Format("{0:X}", Convert.ToInt32(c));
            }
            return hexadecimal;
        }

        static string ConvertTextToBinary(string text)
        {
            string binary = string.Empty;
            foreach (char c in text)
            {
                string charBinary = Convert.ToString(c, 2);
                binary += charBinary.PadLeft(8, '0');
            }
            return binary;
        }
    }
}