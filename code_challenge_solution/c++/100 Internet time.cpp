```cpp
#include <iostream>
#include <cmath>

int main() {
    int hour, minute, second;
    std::cout << "Enter the time in HH:MM:SS format: ";
    std::cin >> hour >> minute >> second;
    
    // Convert time to seconds
    int totalSeconds = (hour * 60 * 60) + (minute * 60) + second;
    
    // Calculate Swatch Internet Time
    double internetTime = totalSeconds / 86.4;
    int decimalPart = std::fmod(internetTime, 1000);
    int integerPart = internetTime / 1000;
    
    std::cout << "Internet Time: " << integerPart << ":" << decimalPart << std::endl;
    
    return 0;
}
```