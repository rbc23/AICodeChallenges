```
// Function to convert temperature from Celsius to Fahrenheit
function celsiusToFahrenheit(celsius) {
    return (celsius * 9/5) + 32;
}
  
// Function to convert temperature from Fahrenheit to Celsius
function fahrenheitToCelsius(fahrenheit) {
    return (fahrenheit - 32) * 5/9;
}
  
// Function to convert temperature from Celsius to Kelvin
function celsiusToKelvin(celsius) {
    return celsius + 273.15;
}
  
// Function to convert temperature from Kelvin to Celsius
function kelvinToCelsius(kelvin) {
    return kelvin - 273.15;
}
  
// Function to convert temperature from Fahrenheit to Kelvin
function fahrenheitToKelvin(fahrenheit) {
    return (fahrenheit + 459.67) * 5/9;
}
  
// Function to convert temperature from Kelvin to Fahrenheit
function kelvinToFahrenheit(kelvin) {
    return (kelvin * 9/5) - 459.67;
}
```

These functions can be used to convert between different temperature units. You can call them with the appropriate input value and they will return the converted temperature value.