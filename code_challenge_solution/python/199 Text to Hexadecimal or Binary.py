text = input("Enter the text: ")
convert_type = input("Enter 'h' for hexadecimal or 'b' for binary conversion: ")

if convert_type == 'h':
    hex_value = ''.join(hex(ord(x))[2:] for x in text)
    print("Hexadecimal: " + hex_value)
elif convert_type == 'b':
    binary_value = ''.join(format(ord(x), '08b') for x in text)
    print("Binary: " + binary_value)
else:
    print("Invalid conversion type. Please enter 'h' or 'b'.")