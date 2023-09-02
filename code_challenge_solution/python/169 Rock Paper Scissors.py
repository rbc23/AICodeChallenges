import random

def get_user_choice():
    user_choice = input("Enter your choice (rock, paper, or scissors): ")
    user_choice = user_choice.lower()
    return user_choice

def get_computer_choice():
    choices = ["rock", "paper", "scissors"]
    computer_choice = random.choice(choices)
    return computer_choice

def determine_winner(user_choice, computer_choice):
    if user_choice == computer_choice:
        return "It's a tie!"
    elif user_choice == "rock":
        if computer_choice == "scissors":
            return "You win!"
        else:
            return "Computer wins!"
    elif user_choice == "paper":
        if computer_choice == "rock":
            return "You win!"
        else:
            return "Computer wins!"
    elif user_choice == "scissors":
        if computer_choice == "paper":
            return "You win!"
        else:
            return "Computer wins!"
    else:
        return "Invalid input!"

def play_game():
    user_choice = get_user_choice()
    computer_choice = get_computer_choice()
    print("You chose:", user_choice)
    print("Computer chose:", computer_choice)
    print(determine_winner(user_choice, computer_choice))

play_game()