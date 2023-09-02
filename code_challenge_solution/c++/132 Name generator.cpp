#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>

std::string generateName() {
    std::string names[] = {"John", "David", "Emily", "Olivia", "William", "Emma", "Michael", "Sophia", "James", "Isabella"};

    int size = sizeof(names) / sizeof(names[0]);
    int index = rand() % size;

    return names[index];
}

int main() {
    // Set the seed for random number generation
    srand(time(0));

    std::cout << "Generated Name: " << generateName() << std::endl;

    return 0;
}