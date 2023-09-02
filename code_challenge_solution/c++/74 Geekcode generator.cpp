```cpp
#include <iostream>
#include <string>

std::string generateGeekcodeSignature(std::string name, std::string occupation, int age) {
    std::string geekcode = "";
    
    geekcode += "-----BEGIN GEEK CODE BLOCK-----\n";
    geekcode += "Version: 3.1\n";
    geekcode += "GCS d++ s+:++ a C++ UL++ P++ L++ E W++ N+ o K- w++ O- M V- PS+++ PE Y++ PGP++ t+ 5 X R tv+ b+++ DI++ D+ G e++ h r++ y++\n";
    geekcode += "------END GEEK CODE BLOCK------\n";
    geekcode += "Name: " + name + "\n";
    geekcode += "Occupation: " + occupation + "\n";
    geekcode += "Age: " + std::to_string(age) + "\n";
    
    return geekcode;
}

int main() {
    std::string name, occupation;
    int age;
    
    std::cout << "Enter your name: ";
    std::getline(std::cin, name);
    
    std::cout << "Enter your occupation: ";
    std::getline(std::cin, occupation);
    
    std::cout << "Enter your age: ";
    std::cin >> age;
    
    std::cin.ignore(); // Ignore the newline character in the input buffer
    
    std::string geekcode = generateGeekcodeSignature(name, occupation, age);
    
    std::cout << "Generated Geekcode Signature:\n";
    std::cout << geekcode;
    
    return 0;
}
```