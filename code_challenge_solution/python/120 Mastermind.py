import random

# Function to generate secret code
def generate_code():
    code = []
    for _ in range(4):
        code.append(random.randint(1, 6))
    return code

# Function to get user guess
def get_guess():
    guess = []
    for _ in range(4):
        guess.append(int(input("Enter a number between 1 and 6: ")))
    return guess

# Function to evaluate guess and provide feedback
def evaluate_guess(code, guess):
    feedback = []
    for i in range(len(code)):
        if guess[i] == code[i]:
            feedback.append("red")
        elif guess[i] in code:
            feedback.append("white")
        else:
            feedback.append("black")
    return feedback

# Main game function
def play_game():
    code = generate_code()
    guess_count = 0
    while True:
        guess_count += 1
        guess = get_guess()
        feedback = evaluate_guess(code, guess)
        print("Feedback:", feedback)
        if guess == code:
            print("Congratulations! You guessed the code in", guess_count, "attempts.")
            break
        
# Start the game
play_game()