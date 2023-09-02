Sure! Here's the C# code to encrypt and decrypt text using a simple caesar cipher:

```csharp
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Enter the text to be encrypted:");
        string originalText = Console.ReadLine();
        int key = 3; // Shift key for encryption
        
        string encryptedText = EncryptText(originalText, key);
        Console.WriteLine("Encrypted Text: " + encryptedText);
        
        string decryptedText = DecryptText(encryptedText, key);
        Console.WriteLine("Decrypted Text: " + decryptedText);
    }
    
    static string EncryptText(string text, int key)
    {
        string encryptedText = "";
        foreach (char c in text)
        {
            if (char.IsLetter(c))
            {
                char encryptedChar = (char)(((int)c + key - 65) % 26 + 65);
                encryptedText += encryptedChar;
            }
            else
            {
                encryptedText += c;
            }
        }
        
        return encryptedText;
    }
    
    static string DecryptText(string text, int key)
    {
        string decryptedText = "";
        foreach (char c in text)
        {
            if (char.IsLetter(c))
            {
                char decryptedChar = (char)(((int)c - key - 65 + 26) % 26 + 65);
                decryptedText += decryptedChar;
            }
            else
            {
                decryptedText += c;
            }
        }
        
        return decryptedText;
    }
}
```

This program takes input from the user as the original text, encrypts it using a Caesar cipher with a shift key of 3, and then decrypts the encrypted text back to its original form. The encrypted and decrypted text are then displayed on the console.