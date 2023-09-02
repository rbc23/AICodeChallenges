#include <iostream>
#include <string>
using namespace std;

string encrypt(string text, int key) {
    string result = ""; 
    for (int i = 0; i < text.length(); i++) {
        if (isalpha(text[i])) { 
            char ch = isupper(text[i]) ? 'A' : 'a';
            result += (text[i] - ch + key) % 26 + ch; 
        } else {
            result += text[i]; 
        }
    }
    return result;
}

string decrypt(string text, int key) {
    return encrypt(text, 26 - key);
}

int main() {
    string text;
    int key;
    
    cout << "Enter text to encrypt: ";
    getline(cin, text);
    
    cout << "Enter key: ";
    cin >> key;
    
    string encryptedText = encrypt(text, key);
    string decryptedText = decrypt(encryptedText, key);
    
    cout << "Encrypted Text: " << encryptedText << endl;
    cout << "Decrypted Text: " << decryptedText << endl;
    
    return 0;
}