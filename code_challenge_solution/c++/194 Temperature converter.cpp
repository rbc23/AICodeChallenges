```cpp
#include <iostream>

double celsiusToFahrenheit(double celsius) {
    return (celsius * 9 / 5) + 32;
}

double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
}

double celsiusToKelvin(double celsius) {
    return celsius + 273.15;
}

double kelvinToCelsius(double kelvin) {
    return kelvin - 273.15;
}

double fahrenheitToKelvin(double fahrenheit) {
    return (fahrenheit + 459.67) * 5 / 9;
}

double kelvinToFahrenheit(double kelvin) {
    return (kelvin * 9 / 5) - 459.67;
}

int main() {
    double temperature;
    int choice;

    std::cout << "Temperature Converter" << std::endl;

    std::cout << "Enter temperature: ";
    std::cin >> temperature;

    std::cout << "Available conversions:" << std::endl;
    std::cout << "1. Celsius to Fahrenheit" << std::endl;
    std::cout << "2. Fahrenheit to Celsius" << std::endl;
    std::cout << "3. Celsius to Kelvin" << std::endl;
    std::cout << "4. Kelvin to Celsius" << std::endl;
    std::cout << "5. Fahrenheit to Kelvin" << std::endl;
    std::cout << "6. Kelvin to Fahrenheit" << std::endl;

    std::cout << "Enter your choice: ";
    std::cin >> choice;

    double convertedTemperature;
    switch (choice) {
        case 1:
            convertedTemperature = celsiusToFahrenheit(temperature);
            std::cout << temperature << " degree Celsius is equal to " << convertedTemperature << " degree Fahrenheit" << std::endl;
            break;
        case 2:
            convertedTemperature = fahrenheitToCelsius(temperature);
            std::cout << temperature << " degree Fahrenheit is equal to " << convertedTemperature << " degree Celsius" << std::endl;
            break;
        case 3:
            convertedTemperature = celsiusToKelvin(temperature);
            std::cout << temperature << " degree Celsius is equal to " << convertedTemperature << " Kelvin" << std::endl;
            break;
        case 4:
            convertedTemperature = kelvinToCelsius(temperature);
            std::cout << temperature << " Kelvin is equal to " << convertedTemperature << " degree Celsius" << std::endl;
            break;
        case 5:
            convertedTemperature = fahrenheitToKelvin(temperature);
            std::cout << temperature << " degree Fahrenheit is equal to " << convertedTemperature << " Kelvin" << std::endl;
            break;
        case 6:
            convertedTemperature = kelvinToFahrenheit(temperature);
            std::cout << temperature << " Kelvin is equal to " << convertedTemperature << " degree Fahrenheit" << std::endl;
            break;
        default:
            std::cout << "Invalid choice" << std::endl;
            break;
    }

    return 0;
}
```