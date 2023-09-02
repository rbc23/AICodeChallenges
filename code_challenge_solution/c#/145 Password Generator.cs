using System;
using System.Linq;

class PasswordGenerator
{
    private const string LowercaseCharacters = "abcdefghijklmnopqrstuvwxyz";
    private const string UppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private const string NumberCharacters = "0123456789";
    private const string SpecialCharacters = "!@#$%^&*()-=_+";

    public static string GeneratePassword(int length, bool includeLowercase, bool includeUppercase, bool includeNumbers, bool includeSpecialCharacters)
    {
        var validChars = string.Empty;

        if (includeLowercase)
        {
            validChars += LowercaseCharacters;
        }

        if (includeUppercase)
        {
            validChars += UppercaseCharacters;
        }

        if (includeNumbers)
        {
            validChars += NumberCharacters;
        }

        if (includeSpecialCharacters)
        {
            validChars += SpecialCharacters;
        }

        if (string.IsNullOrEmpty(validChars))
        {
            throw new ArgumentException("At least one character type must be included.");
        }

        var random = new Random();
        var password = new string(Enumerable.Repeat(validChars, length)
            .Select(s => s[random.Next(s.Length)]).ToArray());

        return password;
    }

    static void Main(string[] args)
    {
        Console.WriteLine("Generate secure random passwords");
        int passwordLength;
        bool includeLowercase, includeUppercase, includeNumbers, includeSpecialCharacters;

        Console.Write("Enter password length: ");
        passwordLength = int.Parse(Console.ReadLine());

        Console.Write("Include lowercase characters (y/n)? ");
        includeLowercase = Console.ReadLine().ToLower() == "y";

        Console.Write("Include uppercase characters (y/n)? ");
        includeUppercase = Console.ReadLine().ToLower() == "y";

        Console.Write("Include numbers (y/n)? ");
        includeNumbers = Console.ReadLine().ToLower() == "y";

        Console.Write("Include special characters (y/n)? ");
        includeSpecialCharacters = Console.ReadLine().ToLower() == "y";

        string password = GeneratePassword(passwordLength, includeLowercase, includeUppercase, includeNumbers, includeSpecialCharacters);

        Console.WriteLine($"Generated password: {password}");

        Console.ReadKey();
    }
}