using System;

class CurrencyConverter
{
    static void Main()
    {
        Console.WriteLine("Currency Converter");
        Console.WriteLine("------------------");

        Console.Write("Enter amount to convert: ");
        double amount = Convert.ToDouble(Console.ReadLine());

        Console.WriteLine("\nCurrency options:");
        Console.WriteLine("1. USD - United States Dollar");
        Console.WriteLine("2. EUR - Euro");
        Console.WriteLine("3. GBP - British Pound");
        Console.WriteLine("4. JPY - Japanese Yen");
        Console.WriteLine("5. AUD - Australian Dollar");

        Console.Write("\nEnter the number of the currency you want to convert from: ");
        int fromCurrency = Convert.ToInt32(Console.ReadLine());

        Console.Write("Enter the number of the currency you want to convert to: ");
        int toCurrency = Convert.ToInt32(Console.ReadLine());

        double convertedAmount = ConvertCurrency(amount, fromCurrency, toCurrency);

        Console.WriteLine("\n{0} {1} is equal to {2} {3}", amount, GetCurrencyName(fromCurrency), convertedAmount, GetCurrencyName(toCurrency));
    }

    static double ConvertCurrency(double amount, int fromCurrency, int toCurrency)
    {
        double convertedAmount = 0;

        switch (fromCurrency)
        {
            case 1:
                convertedAmount = amount;
                break;
            case 2:
                convertedAmount = amount * 0.84; // Conversion rate from USD to EUR
                break;
            case 3:
                convertedAmount = amount * 0.72; // Conversion rate from USD to GBP
                break;
            case 4:
                convertedAmount = amount * 110.12; // Conversion rate from USD to JPY
                break;
            case 5:
                convertedAmount = amount * 1.35; // Conversion rate from USD to AUD
                break;
        }

        switch (toCurrency)
        {
            case 1:
                convertedAmount = convertedAmount;
                break;
            case 2:
                convertedAmount = convertedAmount / 0.84; // Conversion rate from EUR to USD
                break;
            case 3:
                convertedAmount = convertedAmount / 0.72; // Conversion rate from GBP to USD
                break;
            case 4:
                convertedAmount = convertedAmount / 110.12; // Conversion rate from JPY to USD
                break;
            case 5:
                convertedAmount = convertedAmount / 1.35; // Conversion rate from AUD to USD
                break;
        }

        return convertedAmount;
    }

    static string GetCurrencyName(int currency)
    {
        string currencyName = "";

        switch (currency)
        {
            case 1:
                currencyName = "USD";
                break;
            case 2:
                currencyName = "EUR";
                break;
            case 3:
                currencyName = "GBP";
                break;
            case 4:
                currencyName = "JPY";
                break;
            case 5:
                currencyName = "AUD";
                break;
        }

        return currencyName;
    }
}