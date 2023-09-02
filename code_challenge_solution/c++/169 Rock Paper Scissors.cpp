#include <iostream>
#include <cstdlib>
#include <ctime>

int main() {
    srand(time(nullptr));
    
    std::cout << "Welcome to Rock Paper Scissors game!" << std::endl;
    
    std::string choices[3] = {"rock", "paper", "scissors"};
    
    while (true) {
        std::cout << "Choose your move (rock, paper, scissors): ";
        std::string playerChoice;
        std::cin >> playerChoice;
        
        int computerChoice = rand() % 3;
        
        std::cout << "Player chooses: " << playerChoice << std::endl;
        std::cout << "Computer chooses: " << choices[computerChoice] << std::endl;
        
        if (playerChoice == choices[computerChoice]) {
            std::cout << "It's a tie!" << std::endl;
        } else if (playerChoice == "rock") {
            if (choices[computerChoice] == "paper") {
                std::cout << "Computer wins!" << std::endl;
            } else {
                std::cout << "Player wins!" << std::endl;
            }
        } else if (playerChoice == "paper") {
            if (choices[computerChoice] == "scissors") {
                std::cout << "Computer wins!" << std::endl;
            } else {
                std::cout << "Player wins!" << std::endl;
            }
        } else if (playerChoice == "scissors") {
            if (choices[computerChoice] == "rock") {
                std::cout << "Computer wins!" << std::endl;
            } else {
                std::cout << "Player wins!" << std::endl;
            }
        } else {
            std::cout << "Invalid choice. Please try again." << std::endl;
            continue;
        }
        
        std::cout << "Do you want to play again? (y/n): ";
        char playAgain;
        std::cin >> playAgain;
        
        if (playAgain != 'y' && playAgain != 'Y') {
            break;
        }
    }
    
    std::cout << "Thank you for playing. Goodbye!" << std::endl;
    
    return 0;
}