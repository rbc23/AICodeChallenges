import random

def generate_name():
    vowels = 'aeiou'
    consonants = 'bcdfghjklmnpqrstvwxyz'
    
    name = random.choice(consonants).upper()
    name += random.choice(vowels)
    name += random.choice(consonants)
    
    name += random.choice(consonants)
    name += random.choice(vowels)
    name += random.choice(consonants)
    
    return name

num_names = int(input("Enter the number of names to generate: "))

for _ in range(num_names):
    print(generate_name())