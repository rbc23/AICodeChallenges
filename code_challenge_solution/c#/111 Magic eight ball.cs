using System;

namespace MagicEightBall
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] responses = { "It is certain", "Without a doubt", "You may rely on it", "Yes definitely", 
                                   "Most likely", "Outlook good", "Signs point to yes", "Reply hazy try again", 
                                   "Ask again later", "Better not tell you now", "Cannot predict now", 
                                   "Concentrate and ask again", "Don't count on it", "My reply is no", 
                                   "My sources say no", "Outlook not so good", "Very doubtful" };

            Random random = new Random();

            Console.WriteLine("Welcome to the Magic Eight Ball!");

            while (true)
            {
                Console.WriteLine("\nAsk a question or type 'Q' to quit:");
                string input = Console.ReadLine();

                if (input.ToLower() == "q")
                    break;

                int randomIndex = random.Next(0, responses.Length);
                string response = responses[randomIndex];

                Console.WriteLine("Magic Eight Ball says: " + response);
            }

            Console.WriteLine("Thank you for playing the Magic Eight Ball!");
        }
    }
}