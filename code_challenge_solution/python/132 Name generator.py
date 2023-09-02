import random

def generate_name():
    vowels = ["a", "e", "i", "o", "u"]
    consonants = [
        "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", 
        "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"
    ]
    
    name_length = random.randint(5, 10)
    name = ""
    
    # Generate the first letter of the name
    name += random.choice(consonants).upper()
    
    # Generate the rest of the name
    for _ in range(name_length - 1):
        if len(name) % 2 == 0:
            name += random.choice(vowels)
        else:
            name += random.choice(consonants)
    
    return name

# Generate and print 10 random names
for _ in range(10):
    print(generate_name())