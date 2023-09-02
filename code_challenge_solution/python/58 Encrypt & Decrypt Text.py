```python
# Importing cryptography module
from cryptography.fernet import Fernet

# Function to generate key
def generate_key():
    key = Fernet.generate_key()
    with open('key.txt', 'wb') as key_file:
        key_file.write(key)

# Function to load key
def load_key():
    with open('key.txt', 'rb') as key_file:
        key = key_file.read()
    return key

# Function to encrypt message
def encrypt_text(message):
    key = load_key()
    f = Fernet(key)
    encrypted_message = f.encrypt(message.encode())
    return encrypted_message

# Function to decrypt message
def decrypt_text(encrypted_message):
    key = load_key()
    f = Fernet(key)
    decrypted_message = f.decrypt(encrypted_message)
    return decrypted_message.decode()

# Example usage
generate_key()
example_message = "This is an example message."

encrypted_message = encrypt_text(example_message)
print('Encrypted Message:', encrypted_message)

decrypted_message = decrypt_text(encrypted_message)
print('Decrypted Message:', decrypted_message)
```
This program uses the cryptography module to encrypt and decrypt text using Fernet symmetric key encryption. The key used for encryption and decryption is generated once and then stored in a file called "key.txt". The `generate_key()` function generates a new key and saves it to the file, while the `load_key()` function loads the key from the file. The `encrypt_text()` function takes a message as input, encrypts it using the loaded key, and returns the encrypted message. The `decrypt_text()` function takes an encrypted message as input, decrypts it using the loaded key, and returns the decrypted message. An example usage is also provided, where an example message is encrypted and then decrypted again.