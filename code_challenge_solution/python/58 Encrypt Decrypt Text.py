def encrypt(text, key):
    encrypted_text = ""
    for char in text:
        if char.isalpha():
            # Convert the character to ASCII and add the key value
            encrypted_char = chr((ord(char) - 97 + key) % 26 + 97)
            encrypted_text += encrypted_char
        else:
            encrypted_text += char
    return encrypted_text

def decrypt(encrypted_text, key):
    decrypted_text = ""
    for char in encrypted_text:
        if char.isalpha():
            # Convert the character to ASCII and subtract the key value
            decrypted_char = chr((ord(char) - 97 - key) % 26 + 97)
            decrypted_text += decrypted_char
        else:
            decrypted_text += char
    return decrypted_text

text = input("Enter the text: ")
key = int(input("Enter the key: "))

encrypted_text = encrypt(text, key)
print("Encrypted text:", encrypted_text)

decrypted_text = decrypt(encrypted_text, key)
print("Decrypted text:", decrypted_text)
