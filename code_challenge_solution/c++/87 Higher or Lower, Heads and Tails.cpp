#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main() {
    srand(time(0)); // Seed the random number generator

    int randomNumber = rand() % 10 + 1; // Generate a random number between 1 and 10
    int guess;
    bool correctGuess = false;

    cout << "Welcome to Higher or Lower!" << endl;
    cout << "I have generated a random number between 1 and 10." << endl;
    cout << "Your goal is to guess whether the next number will be higher or lower than the current number." << endl;

    while (!correctGuess) {
        cout << "Current number: " << randomNumber << endl;
        cout << "Will the next number be higher or lower? (1. Higher / 2. Lower): ";
        cin >> guess;

        int nextRandomNumber = rand() % 10 + 1;

        if ((nextRandomNumber > randomNumber && guess == 1) || (nextRandomNumber < randomNumber && guess == 2)) {
            cout << "Correct guess!" << endl;
            correctGuess = true;
        } else {
            cout << "Wrong guess! The next number was: " << nextRandomNumber << endl;
            randomNumber = nextRandomNumber;
        }
    }

    cout << "Congratulations! You guessed correctly." << endl;

    cout << endl;
    cout << "Now let's play Heads or Tails." << endl;
    cout << "I will flip a coin and you have to guess whether it will be heads or tails." << endl;
    cout << "Heads = 1, Tails = 2." << endl;

    int coinFlip = rand() % 2 + 1;
    int coinGuess;

    cout << "Enter your guess (1. Heads / 2. Tails): ";
    cin >> coinGuess;

    if (coinFlip == coinGuess) {
        cout << "You guessed correctly! It's " << (coinFlip == 1 ? "Heads" : "Tails") << "." << endl;
    } else {
        cout << "Oops! You guessed wrong. It's " << (coinFlip == 1 ? "Heads" : "Tails") << "." << endl;
    }

    return 0;
}