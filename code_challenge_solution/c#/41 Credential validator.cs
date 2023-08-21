using System;

namespace CredentialValidator
{
    class Program
    {
        static void Main(string[] args)
        {
            string username;
            string password;
            
            // Request username and password from the user
            Console.WriteLine("Enter username: ");
            username = Console.ReadLine();
            Console.WriteLine("Enter password: ");
            password = Console.ReadLine();
            
            // Validate the credentials
            bool isValid = ValidateCredentials(username, password);
            
            // Display the result
            if(isValid)
                Console.WriteLine("Credentials are valid.");
            else
                Console.WriteLine("Invalid credentials.");
        }
        
        static bool ValidateCredentials(string username, string password)
        {
            // Assuming some validation logic here
            if(username == "admin" && password == "password")
                return true;
            else
                return false;
        }
    }
}