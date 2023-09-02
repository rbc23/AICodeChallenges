#include <iostream>

int main() {
    int n;
    std::cout << "Enter the number of terms in the Fibonacci sequence: ";
    std::cin >> n;

    int firstTerm = 0, secondTerm = 1, nextTerm;

    std::cout << "Fibonacci sequence up to " << n << " terms: ";
    std::cout << firstTerm << " " << secondTerm << " ";

    for (int i = 3; i <= n; ++i) {
        nextTerm = firstTerm + secondTerm;
        std::cout << nextTerm << " ";
        firstTerm = secondTerm;
        secondTerm = nextTerm;
    }

    return 0;
}