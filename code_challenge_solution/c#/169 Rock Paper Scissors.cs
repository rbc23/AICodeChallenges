using System;

namespace RockPaperScissors
{
    class Program
    {
        static void Main(string[] args)
        {
            string playerChoice, computerChoice;
            int randomNum;

            Console.WriteLine("Let's play Rock Paper Scissors!");

            // Generate computer's choice
            Random random = new Random();
            randomNum = random.Next(1, 4);

            // Assign the choice based on random number
            switch (randomNum)
            {
                case 1:
                    computerChoice = "Rock";
                    break;
                case 2:
                    computerChoice = "Paper";
                    break;
                case 3:
                    computerChoice = "Scissors";
                    break;
                default:
                    computerChoice = "";
                    break;
            }

            // Get player's choice
            Console.WriteLine("Enter your choice (Rock, Paper, or Scissors):");
            playerChoice = Console.ReadLine().ToLower();

            // Determine the winner
            if (playerChoice == computerChoice.ToLower())
            {
                Console.WriteLine("It's a tie!");
            }
            else if (playerChoice == "rock" && computerChoice == "Scissors")
            {
                Console.WriteLine("You win! Rock beats Scissors.");
            }
            else if (playerChoice == "paper" && computerChoice == "Rock")
            {
                Console.WriteLine("You win! Paper beats Rock.");
            }
            else if (playerChoice == "scissors" && computerChoice == "Paper")
            {
                Console.WriteLine("You win! Scissors beats Paper.");
            }
            else
            {
                Console.WriteLine("Computer wins! " + computerChoice + " beats " + playerChoice + ".");
            }

            Console.ReadLine();
        }
    }
}
