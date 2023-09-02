```cpp
#include <iostream>

// Function to convert from USD to other currencies
void convertFromUSD(float amount)
{
    float convertedAmount;
    
    convertedAmount = amount * 0.84;   // 1 USD = 0.84 EUR
    std::cout << "EUR: " << convertedAmount << std::endl;
    
    convertedAmount = amount * 108.49; // 1 USD = 108.49 JPY
    std::cout << "JPY: " << convertedAmount << std::endl;
    
    convertedAmount = amount * 0.72;   // 1 USD = 0.72 GBP
    std::cout << "GBP: " << convertedAmount << std::endl;
}

// Function to convert from EUR to other currencies
void convertFromEUR(float amount)
{
    float convertedAmount;
    
    convertedAmount = amount * 1.19;    // 1 EUR = 1.19 USD
    std::cout << "USD: " << convertedAmount << std::endl;
    
    convertedAmount = amount * 129.04;  // 1 EUR = 129.04 JPY
    std::cout << "JPY: " << convertedAmount << std::endl;
    
    convertedAmount = amount * 0.86;    // 1 EUR = 0.86 GBP
    std::cout << "GBP: " << convertedAmount << std::endl;
}

// Function to convert from JPY to other currencies
void convertFromJPY(float amount)
{
    float convertedAmount;
    
    convertedAmount = amount * 0.0092;  // 1 JPY = 0.0092 USD
    std::cout << "USD: " << convertedAmount << std::endl;
    
    convertedAmount = amount * 0.0078;  // 1 JPY = 0.0078 EUR
    std::cout << "EUR: " << convertedAmount << std::endl;
    
    convertedAmount = amount * 0.0067;  // 1 JPY = 0.0067 GBP
    std::cout << "GBP: " << convertedAmount << std::endl;
}

// Function to convert from GBP to other currencies
void convertFromGBP(float amount)
{
    float convertedAmount;
    
    convertedAmount = amount * 1.39;    // 1 GBP = 1.39 USD
    std::cout << "USD: " << convertedAmount << std::endl;
    
    convertedAmount = amount * 1.17;    // 1 GBP = 1.17 EUR
    std::cout << "EUR: " << convertedAmount << std::endl;
    
    convertedAmount = amount * 149.84;  // 1 GBP = 149.84 JPY
    std::cout << "JPY: " << convertedAmount << std::endl;
}

int main()
{
    float amount;
    int choice;
    
    std::cout << "Enter the amount to convert: ";
    std::cin >> amount;
    
    std::cout << "Select the currency to convert from:" << std::endl;
    std::cout << "1. USD" << std::endl;
    std::cout << "2. EUR" << std::endl;
    std::cout << "3. JPY" << std::endl;
    std::cout << "4. GBP" << std::endl;
    std::cout << "Enter your choice: ";
    std::cin >> choice;
    
    switch (choice)
    {
        case 1:
            convertFromUSD(amount);
            break;
        case 2:
            convertFromEUR(amount);
            break;
        case 3:
            convertFromJPY(amount);
            break;
        case 4:
            convertFromGBP(amount);
            break;
    }
    
    return 0;
}
```