using System;
using System.Security.Cryptography;
using System.Text;

public class Program
{
    public static void Main(string[] args)
    {
        string text = "Hello World!";
        string key = "SecretKey";

        string encryptedText = EncryptText(text, key);
        Console.WriteLine("Encrypted Text: " + encryptedText);

        string decryptedText = DecryptText(encryptedText, key);
        Console.WriteLine("Decrypted Text: " + decryptedText);
    }

    public static string EncryptText(string text, string key)
    {
        byte[] encryptedBytes;

        using (Aes aes = Aes.Create())
        {
            aes.Key = Encoding.UTF8.GetBytes(key);
            aes.IV = new byte[16];

            ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);

            byte[] textBytes = Encoding.UTF8.GetBytes(text);

            using (MemoryStream memoryStream = new MemoryStream())
            {
                using (CryptoStream cryptoStream = new CryptoStream(memoryStream, encryptor, CryptoStreamMode.Write))
                {
                    cryptoStream.Write(textBytes, 0, textBytes.Length);
                    cryptoStream.FlushFinalBlock();
                }

                encryptedBytes = memoryStream.ToArray();
            }
        }

        return Convert.ToBase64String(encryptedBytes);
    }

    public static string DecryptText(string encryptedText, string key)
    {
        byte[] encryptedBytes = Convert.FromBase64String(encryptedText);
        byte[] decryptedBytes;

        using (Aes aes = Aes.Create())
        {
            aes.Key = Encoding.UTF8.GetBytes(key);
            aes.IV = new byte[16];

            ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);

            using (MemoryStream memoryStream = new MemoryStream(encryptedBytes))
            {
                using (CryptoStream cryptoStream = new CryptoStream(memoryStream, decryptor, CryptoStreamMode.Read))
                {
                    using (StreamReader streamReader = new StreamReader(cryptoStream))
                    {
                        decryptedBytes = Encoding.UTF8.GetBytes(streamReader.ReadToEnd());
                    }
                }
            }
        }

        return Encoding.UTF8.GetString(decryptedBytes);
    }
}