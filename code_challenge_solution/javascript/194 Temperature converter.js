```javascript
function celsiusToFahrenheit(celsius) {
  var fahrenheit = (celsius * 9/5) + 32;
  return fahrenheit;
}

function celsiusToKelvin(celsius) {
  var kelvin = celsius + 273.15;
  return kelvin;
}

function fahrenheitToCelsius(fahrenheit) {
  var celsius = (fahrenheit - 32) * 5/9;
  return celsius;
}

function fahrenheitToKelvin(fahrenheit) {
  var kelvin = (fahrenheit + 459.67) * 5/9;
  return kelvin;
}

function kelvinToCelsius(kelvin) {
  var celsius = kelvin - 273.15;
  return celsius;
}

function kelvinToFahrenheit(kelvin) {
  var fahrenheit = kelvin * 9/5 - 459.67;
  return fahrenheit;
}
```

To use the temperature converter:

```javascript
console.log(celsiusToFahrenheit(25)); // Output: 77
console.log(celsiusToKelvin(25)); // Output: 298.15
console.log(fahrenheitToCelsius(77)); // Output: 25
console.log(fahrenheitToKelvin(77)); // Output: 298.15
console.log(kelvinToCelsius(298.15)); // Output: 25
console.log(kelvinToFahrenheit(298.15)); // Output: 77
```