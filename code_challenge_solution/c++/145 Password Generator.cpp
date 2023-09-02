#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

string generatePassword(int length) {
    const string characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*-_";

    srand(time(0));
    
    string password = "";
    for (int i = 0; i < length; i++) {
        int index = rand() % characters.length();
        password += characters[index];
    }

    return password;
}

int main() {
    int passwordLength;

    cout << "Enter the desired password length: ";
    cin >> passwordLength;

    string password = generatePassword(passwordLength);

    cout << "Generated password: " << password << endl;

    return 0;
}