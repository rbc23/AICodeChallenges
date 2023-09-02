#include <iostream>
#include <string>
#include <algorithm>

bool isPalindrome(const std::string& str) {
    std::string reverseStr = str;
    std::reverse(reverseStr.begin(), reverseStr.end());
    return str == reverseStr;
}

int main() {
    std::string input;
    std::cout << "Enter a string: ";
    std::cin >> input;
    
    if (isPalindrome(input)) {
        std::cout << "Palindrome" << std::endl;
    } else {
        std::cout << "Not a palindrome" << std::endl;
    }
    
    return 0;
}