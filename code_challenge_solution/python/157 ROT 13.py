import string

def rot13(message):
    encrypted_message = ''
    
    for char in message:
        if char.isalpha():
            if char.islower():
                encrypted_message += chr((ord(char) - ord('a') + 13) % 26 + ord('a'))
            else:
                encrypted_message += chr((ord(char) - ord('A') + 13) % 26 + ord('A'))
        else:
            encrypted_message += char
            
    return encrypted_message

message = input("Enter a message: ")
encrypted_message = rot13(message)
print("Encrypted message:", encrypted_message)