var currencyConverter = {
  exchangeRate: {
    USD: {
      EUR: 0.85,
      GBP: 0.72,
      JPY: 109.94,
      AUD: 1.31,
      CAD: 1.23
    },
    EUR: {
      USD: 1.18,
      GBP: 0.85,
      JPY: 130.42,
      AUD: 1.55,
      CAD: 1.47
    },
    GBP: {
      USD: 1.39,
      EUR: 1.18,
      JPY: 154.39,
      AUD: 1.83,
      CAD: 1.73
    },
    JPY: {
      USD: 0.0091,
      EUR: 0.0077,
      GBP: 0.0065,
      AUD: 0.012,
      CAD: 0.012
    },
    AUD: {
      USD: 0.76,
      EUR: 0.65,
      GBP: 0.55,
      JPY: 82.8,
      CAD: 0.94
    },
    CAD: {
      USD: 0.81,
      EUR: 0.68,
      GBP: 0.58,
      JPY: 90.08,
      AUD: 1.06
    }
  },
  
  convert: function(amount, fromCurrency, toCurrency) {
    if (fromCurrency === toCurrency) return amount;
    
    var rate = this.exchangeRate[fromCurrency][toCurrency];
    if (!rate) {
      throw new Error("Conversion from " + fromCurrency + " to " + toCurrency + " is not supported.");
    }
    
    return rate * amount;
  }
};

// Example usage:
var amount = 50;
var fromCurrency = "USD";
var toCurrency = "EUR";

var convertedAmount = currencyConverter.convert(amount, fromCurrency, toCurrency);
console.log(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);