using System;

namespace Mastermind
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Mastermind!");

            Game game = new Game();
            game.Start();

            Console.WriteLine("Thanks for playing!");
        }
    }

    public class Game
    {
        private const int MaxTries = 10;
        private int currentTry;
        private string secretCode;

        public void Start()
        {
            currentTry = 1;
            GenerateSecretCode();

            Console.WriteLine("Guess the 4-digit code (each digit should be between 1 and 6)");

            while (currentTry <= MaxTries)
            {
                string guess = GetUserGuess();
                string feedback = GetFeedback(guess);

                Console.WriteLine(feedback);

                if (guess == secretCode)
                {
                    Console.WriteLine("Congratulations! You cracked the code!");
                    return;
                }

                currentTry++;
            }

            Console.WriteLine("Game over. You ran out of tries. The secret code was: " + secretCode);
        }

        private void GenerateSecretCode()
        {
            Random random = new Random();
            secretCode = "";

            for (int i = 0; i < 4; i++)
            {
                secretCode += random.Next(1, 7);
            }
        }

        private string GetUserGuess()
        {
            Console.Write("Enter your guess: ");
            return Console.ReadLine();
        }

        private string GetFeedback(string guess)
        {
            int correctPosition = 0;
            int correctColor = 0;

            for (int i = 0; i < 4; i++)
            {
                if (guess[i] == secretCode[i])
                {
                    correctPosition++;
                }
                else if (secretCode.Contains(guess[i].ToString()))
                {
                    correctColor++;
                }
            }

            return "Correct position: " + correctPosition + ", Correct color: " + correctColor;
        }
    }
}