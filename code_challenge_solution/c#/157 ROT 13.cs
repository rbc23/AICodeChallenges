using System;

class Program
{
    static void Main(string[] args)
    {
        string input = "Hello, World!";
        string output = ROT13(input);
        Console.WriteLine(output);
    }

    static string ROT13(string input)
    {
        char[] array = input.ToCharArray();

        for (int i = 0; i < array.Length; i++)
        {
            if (char.IsLetter(array[i]))
            {
                char baseChar = char.IsUpper(array[i]) ? 'A' : 'a';
                array[i] = (char)((array[i] - baseChar + 13) % 26 + baseChar);
            }
        }

        return new string(array);
    }
}