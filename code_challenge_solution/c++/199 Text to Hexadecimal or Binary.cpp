#include <iostream>
#include <string>
#include <sstream>

std::string textToHex(const std::string& text) {
    std::stringstream hexStream;
    hexStream << std::hex << std::uppercase;

    for (int i = 0; i < text.length(); ++i) {
        hexStream << static_cast<int>(text[i]);
    }

    return hexStream.str();
}

std::string textToBinary(const std::string& text) {
    std::stringstream binaryStream;

    for (int i = 0; i < text.length(); ++i) {
        for (int j = 7; j >= 0; --j) {
            binaryStream << ((text[i] >> j) & 1);
        }
    }

    return binaryStream.str();
}

int main() {
    std::string text;
    std::cout << "Enter text: ";
    std::getline(std::cin, text);
    
    std::string hex = textToHex(text);
    std::string binary = textToBinary(text);
    
    std::cout << "Hexadecimal: " << hex << std::endl;
    std::cout << "Binary: " << binary << std::endl;

    return 0;
}