#include <iostream>
#include <string>
#include <vector>

using namespace std;

void printHangman(int hangmanState) {
    if(hangmanState == 0) {
        cout << " _________     " << endl;
        cout << "|         |    " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
    } else if(hangmanState == 1) {
        cout << " _________     " << endl;
        cout << "|         |    " << endl;
        cout << "|         0    " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
    } else if(hangmanState == 2) {
        cout << " _________     " << endl;
        cout << "|         |    " << endl;
        cout << "|         0    " << endl;
        cout << "|         |    " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
    } else if(hangmanState == 3) {
        cout << " _________     " << endl;
        cout << "|         |    " << endl;
        cout << "|         0    " << endl;
        cout << "|        /|    " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
    } else if(hangmanState == 4) {
        cout << " _________     " << endl;
        cout << "|         |    " << endl;
        cout << "|         0    " << endl;
        cout << "|        /|\\  " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
    } else if(hangmanState == 5) {
        cout << " _________     " << endl;
        cout << "|         |    " << endl;
        cout << "|         0    " << endl;
        cout << "|        /|\\  " << endl;
        cout << "|        /     " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
    } else {
        cout << " _________     " << endl;
        cout << "|         |    " << endl;
        cout << "|         0    " << endl;
        cout << "|        /|\\  " << endl;
        cout << "|        / \\  " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
        cout << "|              " << endl;
    }
}

bool isWordGuessed(string word, vector<char> guesses) {
    for(int i = 0; i < word.length(); i++) {
        bool guessed = false;
        for(char c : guesses) {
            if(word[i] == c) {
                guessed = true;
                break;
            }
        }
        if(!guessed) {
            return false;
        }
    }
    return true;
}

void printWord(string word, vector<char> guesses) {
    for(int i = 0; i < word.length(); i++) {
        bool guessed = false;
        for(char c : guesses) {
            if(word[i] == c) {
                guessed = true;
                break;
            }
        }
        if(guessed) {
            cout << word[i] << " ";
        } else {
            cout << "_ ";
        }
    }
    cout << endl;
}

int main() {
    vector<string> wordList = {"apple", "banana", "cherry", "durian", "elderberry", "fig"};
    srand(time(0));
    int randomIndex = rand() % wordList.size();
    string wordToGuess = wordList[randomIndex];

    int attempts = 0;
    vector<char> guesses;

    cout << "Welcome to Hangman!" << endl;

    while(attempts < 6) {
        cout << endl;
        printHangman(attempts);
        cout << endl;
        printWord(wordToGuess, guesses);
        cout << endl;

        cout << "Enter a letter: ";
        char guess;
        cin >> guess;

        guesses.push_back(guess);

        if(wordToGuess.find(guess) != string::npos) {
            cout << "Correct guess!" << endl;
        } else {
            cout << "Wrong guess!" << endl;
            attempts++;
        }

        if(isWordGuessed(wordToGuess, guesses)) {
            cout << endl;
            printWord(wordToGuess, guesses);
            cout << endl;
            cout << "Congratulations! You won!" << endl;
            break;
        }
    }

    if(attempts == 6) {
        cout << "You lost. The word was " << wordToGuess << "." << endl;
    }

    return 0;
}