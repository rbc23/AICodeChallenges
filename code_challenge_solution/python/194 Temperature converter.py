# Temperature conversion function from Celsius to Fahrenheit
def celsius_to_fahrenheit(celsius):
    fahrenheit = (celsius * 9/5) + 32
    return fahrenheit

# Temperature conversion function from Fahrenheit to Celsius
def fahrenheit_to_celsius(fahrenheit):
    celsius = (fahrenheit - 32) * 5/9
    return celsius

# Temperature conversion function from Celsius to Kelvin
def celsius_to_kelvin(celsius):
    kelvin = celsius + 273.15
    return kelvin

# Temperature conversion function from Kelvin to Celsius
def kelvin_to_celsius(kelvin):
    celsius = kelvin - 273.15
    return celsius

# Temperature conversion function from Fahrenheit to Kelvin
def fahrenheit_to_kelvin(fahrenheit):
    kelvin = (fahrenheit - 32) * 5/9 + 273.15
    return kelvin

# Temperature conversion function from Kelvin to Fahrenheit
def kelvin_to_fahrenheit(kelvin):
    fahrenheit = (kelvin - 273.15) * 9/5 + 32
    return fahrenheit


# test the conversion functions
print(celsius_to_fahrenheit(20))     # Expected output: 68.0
print(fahrenheit_to_celsius(68))     # Expected output: 20.0
print(celsius_to_kelvin(20))         # Expected output: 293.15
print(kelvin_to_celsius(293.15))     # Expected output: 20.0
print(fahrenheit_to_kelvin(68))      # Expected output: 293.15
print(kelvin_to_fahrenheit(293.15))  # Expected output: 68.0