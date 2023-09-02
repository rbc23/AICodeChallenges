```javascript
// Function to convert between currencies
function convertCurrency(amount, fromCurrency, toCurrency) {
  // API endpoint for currency conversion
  const apiUrl = `https://api.exchangerate-api.com/v4/latest/${fromCurrency}`;

  // Make a GET request to the API endpoint
  fetch(apiUrl)
    .then(response => response.json())
    .then(data => {
      // Get the exchange rate for the target currency
      const exchangeRate = data.rates[toCurrency];

      // Convert the amount
      const convertedAmount = amount * exchangeRate;

      // Log the result
      console.log(`${amount} ${fromCurrency} = ${convertedAmount} ${toCurrency}`);
    })
    .catch(error => console.error(error));
}

// Usage example
convertCurrency(100, 'USD', 'EUR');
```
Note: This code uses the `fetch` API to make a GET request to an external API to get the currency exchange rates. Make sure to include this code in an environment that supports the `fetch` API (e.g., a browser or Node.js with a polyfill).