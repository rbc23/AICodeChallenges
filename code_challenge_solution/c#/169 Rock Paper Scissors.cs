using System;

namespace RockPaperScissors
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] choices = { "rock", "paper", "scissors" };

            Console.WriteLine("Let's play Rock Paper Scissors!");

            while (true)
            {
                // Get user's choice
                Console.WriteLine("Enter your choice (rock, paper, or scissors): ");
                string userChoice = Console.ReadLine().ToLower();

                // Generate computer's choice
                Random random = new Random();
                int index = random.Next(choices.Length);
                string computerChoice = choices[index];

                // Determine the winner
                Console.WriteLine("The computer chose: " + computerChoice);

                if (userChoice == computerChoice)
                {
                    Console.WriteLine("It's a tie!");
                }
                else if (userChoice == "rock" && computerChoice == "scissors" || 
                         userChoice == "paper" && computerChoice == "rock" || 
                         userChoice == "scissors" && computerChoice == "paper")
                {
                    Console.WriteLine("You win!");
                }
                else
                {
                    Console.WriteLine("Computer wins!");
                }

                Console.WriteLine("");
                Console.WriteLine("Do you want to play again? (yes or no)");
                string playAgain = Console.ReadLine().ToLower();

                if (playAgain != "yes")
                {
                    break;
                }
                Console.Clear();
            }
        }
    }
}