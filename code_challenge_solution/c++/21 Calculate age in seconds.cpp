#include <iostream>

int main() {
    int age, seconds;

    std::cout << "Enter your age: ";
    std::cin >> age;

    seconds = age * 365 * 24 * 60 * 60;

    std::cout << "Your age in seconds is: " << seconds << std::endl;

    return 0;
}