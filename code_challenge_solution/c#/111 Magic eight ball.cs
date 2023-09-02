using System;

namespace MagicEightBall
{
    class Program
    {
        static void Main(string[] args)
        {
            // Array of possible answers from the magic eight ball
            string[] answers = {"It is certain", "It is decidedly so", "Without a doubt", "Yes - definitely",
                                "You may rely on it", "As I see it, yes", "Most likely", "Outlook good",
                                "Yes", "Signs point to yes", "Reply hazy, try again", "Ask again later",
                                "Better not tell you now", "Cannot predict now", "Concentrate and ask again",
                                "Don't count on it", "My reply is no", "My sources say no", "Outlook not so good",
                                "Very doubtful"};

            Random random = new Random();

            // Generate a random index to get a random answer
            int index = random.Next(0, answers.Length);

            // Print the magic eight ball answer
            Console.WriteLine("Magic Eight Ball says: " + answers[index]);
        }
    }
}