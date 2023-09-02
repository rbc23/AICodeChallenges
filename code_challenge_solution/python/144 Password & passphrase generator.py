import random
import string

def generate_password(length):
    characters = string.ascii_letters + string.digits + string.punctuation
    password = ''.join(random.choice(characters) for _ in range(length))
    return password

def generate_passphrase(num_words):
    with open('wordlist.txt', 'r') as wordlist_file:
        wordlist = wordlist_file.readlines()

    passphrase = ''
    for _ in range(num_words):
        word = random.choice(wordlist).strip()
        passphrase += word + ' '

    return passphrase.strip()

print("Generated Password:", generate_password(10))
print("Generated Passphrase:", generate_passphrase(5))