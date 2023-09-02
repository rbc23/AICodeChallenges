import random

def higher_or_lower():
    num1 = random.randint(1, 10)
    num2 = random.randint(1, 10)
    
    print("Number 1: ", num1)
    print("Number 2: ", num2)
    
    guess = input("Guess if the next number will be higher or lower (h/l): ")
    
    if guess.lower() == 'h' and num2 > num1:
        print("Correct! The next number is higher.")
    elif guess.lower() == 'l' and num2 < num1:
        print("Correct! The next number is lower.")
    else:
        print("Wrong! The next number is", num2)


def heads_or_tails():
    coin = random.randint(0, 1)
    
    guess = input("Guess heads or tails (h/t): ")
    
    if guess.lower() == 'h' and coin == 0:
        print("Correct! It's heads.")
    elif guess.lower() == 't' and coin == 1:
        print("Correct! It's tails.")
    else:
        print("Wrong! It's", "heads" if coin == 0 else "tails")


higher_or_lower()
heads_or_tails()