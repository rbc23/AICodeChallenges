import random

def generate_haiku():
    # List of words for each line of the haiku
    line1 = ['Autumn', 'Winter', 'Spring', 'Summer']
    line2 = ['leaves', 'snowflakes', 'blossoms', 'sunlight']
    line3 = ['falling', 'melting', 'blooming', 'shining']

    # Randomly select a word for each line
    word1 = random.choice(line1)
    word2 = random.choice(line2)
    word3 = random.choice(line3)

    # Construct the haiku poem
    haiku = f"{word1} {word2} {word3}"

    return haiku

# Generate and print a haiku poem
haiku = generate_haiku()
print(haiku)