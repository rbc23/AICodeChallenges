```cpp
#include <iostream>
#include <string>

void viewImage(const std::string& imageName) {
    std::cout << "Viewing image: " << imageName << std::endl;
    // Add code to display the image here
}

int main() {
    std::string imageName;

    // Prompt user for image name
    std::cout << "Enter the name of the image: ";
    std::cin >> imageName;

    // Call the viewImage function
    viewImage(imageName);

    return 0;
}
```