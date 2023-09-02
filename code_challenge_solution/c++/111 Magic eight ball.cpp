#include <iostream>
#include <cstdlib>
#include <ctime>

int main() {
    srand(time(0));
    std::string answers[8] = {"It is certain.", "It is decidedly so.", "Without a doubt.",
                              "Yes - definitely.", "You may rely on it.", "As I see it, yes.",
                              "Most likely.", "Outlook good."};

    std::cout << "Magic Eight Ball Simulator\n";
    std::cout << "Think of a yes/no question and shake the ball to get the answer!\n\n";
    
    std::cout << "To shake the ball, press Enter.";
    std::cin.get();

    int randomIndex = rand() % 8;
    std::string answer = answers[randomIndex];

    std::cout << "The answer is: " << answer << std::endl;

    return 0;
}