using System;
using System.Security.Cryptography;

namespace PasswordGenerator
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to the Password Generator!");
            Console.WriteLine("---------------------------------");

            // Prompt the user for password length
            Console.Write("Enter the desired password length: ");
            int length = int.Parse(Console.ReadLine());

            // Generate the password
            string password = GeneratePassword(length);

            // Display the generated password
            Console.WriteLine("\nGenerated Password: " + password);
        }

        static string GeneratePassword(int length)
        {
            const string validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
            char[] passwordChars = new char[length];

            using (RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider())
            {
                byte[] randomBytes = new byte[length * 4];
                rng.GetBytes(randomBytes);

                for (int i = 0; i < length; i++)
                {
                    int randomValue = BitConverter.ToInt32(randomBytes, i * 4);
                    int randomIndex = (int)(randomValue % validChars.Length);
                    passwordChars[i] = validChars[randomIndex];
                }
            }

            return new string(passwordChars);
        }
    }
}