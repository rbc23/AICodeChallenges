// Celsius to Fahrenheit
function celsiusToFahrenheit(celsius) {
  return (celsius * 9/5) + 32;
}

// Fahrenheit to Celsius
function fahrenheitToCelsius(fahrenheit) {
  return (fahrenheit - 32) * 5/9;
}

// Celsius to Kelvin
function celsiusToKelvin(celsius) {
  return celsius + 273.15;
}

// Kelvin to Celsius
function kelvinToCelsius(kelvin) {
  return kelvin - 273.15;
}

// Fahrenheit to Kelvin
function fahrenheitToKelvin(fahrenheit) {
  return (fahrenheit + 459.67) * 5/9;
}

// Kelvin to Fahrenheit
function kelvinToFahrenheit(kelvin) {
  return (kelvin * 9/5) - 459.67;
}