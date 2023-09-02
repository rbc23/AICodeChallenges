using System;

namespace CurrencyConverter
{
    class Program
    {
        static void Main(string[] args)
        {
            double amount;
            string fromCurrency, toCurrency;

            Console.Write("Enter the amount to convert: ");
            amount = double.Parse(Console.ReadLine());

            Console.Write("Enter your base currency: ");
            fromCurrency = Console.ReadLine().ToUpper();

            Console.Write("Enter the target currency: ");
            toCurrency = Console.ReadLine().ToUpper();

            double convertedAmount = ConvertCurrency(amount, fromCurrency, toCurrency);

            Console.WriteLine($"{amount} {fromCurrency} is equal to {convertedAmount} {toCurrency}");
        }

        static double ConvertCurrency(double amount, string fromCurrency, string toCurrency)
        {
            double convertedAmount = 0;

            // Conversion rates for popular currencies
            double usdToEur = 0.85;
            double usdToGbp = 0.75;
            double usdToJpy = 109.95;
            double usdToInr = 74.00;
            double eurToUsd = 1.18;
            double eurToGbp = 0.88;
            double eurToJpy = 130.22;
            double eurToInr = 88.11;
            double gbpToUsd = 1.34;
            double gbpToEur = 1.14;
            double gbpToJpy = 148.26;
            double gbpToInr = 100.22;
            double jpyToUsd = 0.0091;
            double jpyToEur = 0.0077;
            double jpyToGbp = 0.0067;
            double jpyToInr = 0.67;
            double inrToUsd = 0.014;
            double inrToEur = 0.011;
            double inrToGbp = 0.010;
            double inrToJpy = 1.5;

            if (fromCurrency == "USD" && toCurrency == "EUR")
            {
                convertedAmount = amount * usdToEur;
            }
            else if (fromCurrency == "USD" && toCurrency == "GBP")
            {
                convertedAmount = amount * usdToGbp;
            }
            else if (fromCurrency == "USD" && toCurrency == "JPY")
            {
                convertedAmount = amount * usdToJpy;
            }
            else if (fromCurrency == "USD" && toCurrency == "INR")
            {
                convertedAmount = amount * usdToInr;
            }
            else if (fromCurrency == "EUR" && toCurrency == "USD")
            {
                convertedAmount = amount * eurToUsd;
            }
            else if (fromCurrency == "EUR" && toCurrency == "GBP")
            {
                convertedAmount = amount * eurToGbp;
            }
            else if (fromCurrency == "EUR" && toCurrency == "JPY")
            {
                convertedAmount = amount * eurToJpy;
            }
            else if (fromCurrency == "EUR" && toCurrency == "INR")
            {
                convertedAmount = amount * eurToInr;
            }
            else if (fromCurrency == "GBP" && toCurrency == "USD")
            {
                convertedAmount = amount * gbpToUsd;
            }
            else if (fromCurrency == "GBP" && toCurrency == "EUR")
            {
                convertedAmount = amount * gbpToEur;
            }
            else if (fromCurrency == "GBP" && toCurrency == "JPY")
            {
                convertedAmount = amount * gbpToJpy;
            }
            else if (fromCurrency == "GBP" && toCurrency == "INR")
            {
                convertedAmount = amount * gbpToInr;
            }
            else if (fromCurrency == "JPY" && toCurrency == "USD")
            {
                convertedAmount = amount * jpyToUsd;
            }
            else if (fromCurrency == "JPY" && toCurrency == "EUR")
            {
                convertedAmount = amount * jpyToEur;
            }
            else if (fromCurrency == "JPY" && toCurrency == "GBP")
            {
                convertedAmount = amount * jpyToGbp;
            }
            else if (fromCurrency == "JPY" && toCurrency == "INR")
            {
                convertedAmount = amount * jpyToInr;
            }
            else if (fromCurrency == "INR" && toCurrency == "USD")
            {
                convertedAmount = amount * inrToUsd;
            }
            else if (fromCurrency == "INR" && toCurrency == "EUR")
            {
                convertedAmount = amount * inrToEur;
            }
            else if (fromCurrency == "INR" && toCurrency == "GBP")
            {
                convertedAmount = amount * inrToGbp;
            }
            else if (fromCurrency == "INR" && toCurrency == "JPY")
            {
                convertedAmount = amount * inrToJpy;
            }

            return convertedAmount;
        }
    }
}