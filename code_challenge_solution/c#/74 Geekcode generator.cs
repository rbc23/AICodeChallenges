using System;

namespace GeekcodeGenerator
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Geekcode Generator");
            Console.WriteLine("==================");

            Console.Write("Enter your name: ");
            string name = Console.ReadLine();

            Console.Write("Enter your age: ");
            int age = Int32.Parse(Console.ReadLine());

            Console.Write("Enter your favorite programming language: ");
            string favLanguage = Console.ReadLine();

            Console.Write("Enter your favorite game: ");
            string favGame = Console.ReadLine();

            Console.Write("Enter the number of hours you spend coding daily: ");
            int hoursCoding = Int32.Parse(Console.ReadLine());

            Console.WriteLine();

            Console.WriteLine("Your Geekcode Signature:");
            Console.WriteLine("------------------------");

            string geekcode = "GEEK-" + name.Substring(0, 3).ToUpper() + "-" + age.ToString() + "-" + favLanguage.Substring(0, 3).ToUpper() + "-" + favGame.Substring(0, 3).ToUpper() + "-" + hoursCoding.ToString();

            Console.WriteLine(geekcode);
        }
    }
}