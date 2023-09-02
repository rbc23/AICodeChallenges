#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    string str;
    cout << "Enter a string: ";
    getline(cin, str);

    unordered_map<char, int> charCount;

    for (char ch : str) {
        if (isspace(ch)) {
            continue;
        }
        charCount[ch]++;
    }

    cout << "Character Frequency: " << endl;
    for (auto pair : charCount) {
        cout << pair.first << " : " << pair.second << endl;
    }

    return 0;
}