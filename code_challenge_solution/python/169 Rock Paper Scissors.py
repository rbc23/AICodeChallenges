import random

choices = ["rock", "paper", "scissors"]

def play_game():
    print("Rock Paper Scissors")
    print("-------------------")
    
    player_choice = input("Your choice: ").lower()
    while player_choice not in choices:
        print("Invalid choice. Please choose again.")
        player_choice = input("Your choice: ").lower()
    
    computer_choice = random.choice(choices)
    print("Computer's choice:", computer_choice)
    
    if player_choice == computer_choice:
        print("It's a tie!")
    elif (player_choice == "rock" and computer_choice == "scissors") or \
         (player_choice == "paper" and computer_choice == "rock") or \
         (player_choice == "scissors" and computer_choice == "paper"):
        print("You win!")
    else:
        print("You lose!")

play_game()