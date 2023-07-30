import random

def generate_code():
    code = []
    for _ in range(4):
        code.append(random.randint(1, 6))
    return code

def check_guess(guess, code):
    correct_color = 0
    correct_position = 0
    code_counts = [0] * 6
    guess_counts = [0] * 6
    
    for i in range(4):
        if guess[i] == code[i]:
            correct_position += 1
        else:
            code_counts[code[i] - 1] += 1
            guess_counts[guess[i] - 1] += 1
    
    for i in range(6):
        correct_color += min(code_counts[i], guess_counts[i])
    
    return correct_position, correct_color

def play_game():
    code = generate_code()
    attempts = 0
    
    print("Welcome to Mastermind!")
    print("Guess the code (4 digits from 1 to 6).")
    
    while True:
        guess = []
        for _ in range(4):
            while True:
                try:
                    digit = int(input("Enter a digit: "))
                    if digit < 1 or digit > 6:
                        raise ValueError
                    break
                except ValueError:
                    print("Invalid input. Please enter a digit from 1 to 6.")
            guess.append(digit)
        
        attempts += 1
        correct_position, correct_color = check_guess(guess, code)
        
        print("Correct digits in correct positions: ", correct_position)
        print("Correct digits but in wrong positions: ", correct_color)
        
        if correct_position == 4:
            print("Congratulations! You cracked the code in", attempts, "attempts!")
            break

play_game()