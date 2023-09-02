using System;
using System.Linq;
using System.Security.Cryptography;

class Program
{
    static void Main()
    {
        int passwordLength = 10; // you can change the desired length of the password here

        string password = GenerateSecurePassword(passwordLength);
        Console.WriteLine("Secure Password: " + password);

        int passphraseLength = 4; // you can change the desired length of the passphrase here

        string passphrase = GeneratePassphrase(passphraseLength);
        Console.WriteLine("Secure Passphrase: " + passphrase);
    }

    static string GenerateSecurePassword(int length)
    {
        const string validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+";

        using (var rng = new RNGCryptoServiceProvider())
        {
            var byteBuffer = new byte[length];
            rng.GetBytes(byteBuffer);

            var chars = byteBuffer.Select(b => validChars[b % validChars.Length]);
            return new string(chars.ToArray());
        }
    }

    static string GeneratePassphrase(int length)
    {
        const string validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        using (var rng = new RNGCryptoServiceProvider())
        {
            var byteBuffer = new byte[length];
            rng.GetBytes(byteBuffer);

            var chars = byteBuffer.Select(b => validChars[b % validChars.Length]);
            return new string(chars.ToArray());
        }
    }
}