Sure! Here's a C++ program to create a basic text editor:

```cpp
#include <iostream>
#include <fstream>

int main() {
    std::string filename;
    std::string text;

    std::cout << "Enter the file name: ";
    std::cin >> filename;

    std::ifstream file(filename);
    if (file) {
        std::cout << "The file " << filename << " already exists. Do you want to overwrite it? (Y/N): ";
        char choice;
        std::cin >> choice;
        if (choice == 'N' || choice == 'n') {
            std::cout << "Exiting...\n";
            return 0;
        }
    }
    file.close();

    std::cout << "Enter the text (press Ctrl+D to save and exit):\n";
    std::cin.ignore();
    while (std::cin) {
        std::string line;
        std::getline(std::cin, line);
        text += line + '\n';
    }

    std::ofstream outFile(filename);
    outFile << text;
    outFile.close();

    std::cout << "File saved successfully!\n";

    return 0;
}
```

This program prompts the user to enter a filename and then allows the user to enter text. The text is then saved to the specified file. If the file already exists, the program asks the user if they want to overwrite it.