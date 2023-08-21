using System;
using System.Security.Cryptography;

namespace PasswordGenerator
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to the Password Generator!");

            Console.WriteLine("Please choose an option:");
            Console.WriteLine("1. Generate a random password");
            Console.WriteLine("2. Generate a random passphrase");
            Console.Write("Enter your choice: ");
            int option = Convert.ToInt32(Console.ReadLine());

            if (option == 1)
            {
                Console.WriteLine("Please choose the length of the password: ");
                int length = Convert.ToInt32(Console.ReadLine());
                string password = GeneratePassword(length);
                Console.WriteLine("Random Password: " + password);
            }
            else if (option == 2)
            {
                Console.WriteLine("Please choose the number of words in the passphrase: ");
                int numWords = Convert.ToInt32(Console.ReadLine());
                string passphrase = GeneratePassphrase(numWords);
                Console.WriteLine("Random Passphrase: " + passphrase);
            }
            else
            {
                Console.WriteLine("Invalid option. Please choose either 1 or 2.");
            }
        }

        static string GeneratePassword(int length)
        {
            const string validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
            using (RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider())
            {
                byte[] buffer = new byte[length];
                rng.GetBytes(buffer);

                StringBuilder passwordBuilder = new StringBuilder(length);

                foreach (byte b in buffer)
                {
                    passwordBuilder.Append(validChars[b % validChars.Length]);
                }

                return passwordBuilder.ToString();
            }
        }

        static string GeneratePassphrase(int numWords)
        {
            const string validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            const string wordListPath = "wordlist.txt";

            string[] words = File.ReadAllLines(wordListPath);
            int numWordsInList = words.Length;
            
            using (RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider())
            {
                byte[] buffer = new byte[numWords];
                rng.GetBytes(buffer);

                StringBuilder passphraseBuilder = new StringBuilder();

                foreach (byte b in buffer)
                {
                    int index = b % numWordsInList;
                    passphraseBuilder.Append(words[index]);
                    passphraseBuilder.Append(" ");
                }

                return passphraseBuilder.ToString().TrimEnd();
            }
        }
    }
}