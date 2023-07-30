import random
import string

def generate_password(length):
    characters = string.ascii_letters + string.digits + string.punctuation
    password = ''.join(random.choice(characters) for _ in range(length))
    return password

def generate_passphrase(num_words):
    with open('english_words.txt', 'r') as file:
        words_list = file.readlines()
        
    words_list = [word.strip().lower() for word in words_list]
    passphrase = ' '.join(random.choice(words_list) for _ in range(num_words))
    return passphrase

print("Secure Password:")
print(generate_password(10))

print("Secure Passphrase:")
print(generate_passphrase(4))