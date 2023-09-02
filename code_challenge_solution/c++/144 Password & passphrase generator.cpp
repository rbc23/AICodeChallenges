#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;

string generatePassword(int length) {
    string password = "";
    string characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";

    srand(time(0));

    for (int i = 0; i < length; i++) {
        int randomIndex = rand() % characters.length();
        password += characters[randomIndex];
    }

    return password;
}

string generatePassphrase(int length) {
    string passphrase = "";
    string words[] = {"apple", "banana", "orange", "grape", "watermelon", "kiwi", "pineapple", "mango", "strawberry", "blueberry"};

    srand(time(0));

    for (int i = 0; i < length; i++) {
        int randomIndex = rand() % 10;
        passphrase += words[randomIndex];

        if (i < length - 1) {
            passphrase += " ";
        }
    }

    return passphrase;
}

int main() {
    int choice;
    int length;

    cout << "Password & Passphrase Generator" << endl;
    cout << "1. Generate Password" << endl;
    cout << "2. Generate Passphrase" << endl;
    cout << "Enter your choice: ";
    cin >> choice;

    if (choice == 1) {
        cout << "Enter the length of the password: ";
        cin >> length;
        cout << "Generated Password: " << generatePassword(length) << endl;
    } else if (choice == 2) {
        cout << "Enter the length of the passphrase: ";
        cin >> length;
        cout << "Generated Passphrase: " << generatePassphrase(length) << endl;
    } else {
        cout << "Invalid choice" << endl;
    }

    return 0;
}