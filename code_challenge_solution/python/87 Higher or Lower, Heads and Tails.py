import random

def higher_lower(num):
    guess = int(input("Guess a number between 1 and 100: "))
    if guess < num:
        print("Higher!")
    elif guess > num:
        print("Lower!")
    else:
        print("Correct!")

def heads_tails():
    guess = input("Guess heads or tails (h/t): ")
    coin = random.choice(["h", "t"])
    if guess == coin:
        print("Correct!")
    else:
        print("Wrong!")

def flip_coin():
    result = random.choice(["Heads", "Tails"])
    print("The coin landed on", result)

number_to_guess = random.randint(1, 100)
higher_lower(number_to_guess)
heads_tails()
flip_coin()