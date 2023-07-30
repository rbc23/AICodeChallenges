import requests

def currency_converter(amount, from_currency, to_currency):
    url = f"https://api.exchangerate-api.com/v4/latest/{from_currency}"

    response = requests.get(url)
    data = response.json()
    
    exchange_rate = data['rates'][to_currency]
    converted_amount = amount * exchange_rate
    
    return converted_amount

amount = float(input("Enter the amount: "))
from_currency = input("Enter the currency to convert from: ")
to_currency = input("Enter the currency to convert to: ")

converted_amount = currency_converter(amount, from_currency, to_currency)
print(f"{amount} {from_currency} is equal to {converted_amount} {to_currency}")
