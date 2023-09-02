Here is the C++ code to create a credential validator for validating username or password credentials:

```cpp
#include <iostream>
#include <cstring>

bool validateUsername(const char* username) {
    // Check if username meets the validation criteria
    // Return true if username is valid, false otherwise
    // You can customize the validation logic according to your requirements
    // Example: Checking if username is at least 5 characters long
    return (std::strlen(username) >= 5);
}

bool validatePassword(const char* password) {
    // Check if password meets the validation criteria
    // Return true if password is valid, false otherwise
    // You can customize the validation logic according to your requirements
    // Example: Checking if password is at least 8 characters long
    return (std::strlen(password) >= 8);
}

int main() {
    char username[100];
    char password[100];

    std::cout << "Enter username: ";
    std::cin.getline(username, sizeof(username));

    std::cout << "Enter password: ";
    std::cin.getline(password, sizeof(password));

    if (validateUsername(username) && validatePassword(password)) {
        std::cout << "Credentials are valid." << std::endl;
    } else {
        std::cout << "Invalid credentials." << std::endl;
    }

    return 0;
}
```

This code defines two functions `validateUsername` and `validatePassword` that implement the validation criteria for the username and password respectively. You can customize these functions to define your own criteria.

In the `main` function, the user is prompted to enter their username and password. The `validateUsername` and `validatePassword` functions are called to check if the entered credentials are valid. If both the username and password passes the validation, the program prints "Credentials are valid". Otherwise, it prints "Invalid credentials".