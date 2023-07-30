import random
import time

colors = ['red', 'blue', 'green', 'yellow']
sequence = []
player_sequence = []
rounds = 1

def generate_sequence():
    global sequence
    sequence.append(random.choice(colors))

def take_turn():
    global player_sequence
    player_sequence.clear()
    print("Round:", rounds)
    print("Pay attention to the sequence!")
    time.sleep(1)

    for color in sequence:
        print(color)
        time.sleep(1)

        # clear console
        print("\033c", end="")

        # wait for input
        player_color = input("Enter the color: ")

        # check input
        if color[0].lower() != player_color[0].lower():
            print("Wrong color! You lose!")
            print("Game Over!")
            return

        player_sequence.append(player_color)

    print("Correct!")
    print("Your sequence:", player_sequence)

def play_game():
    while True:
        generate_sequence()
        take_turn()
        rounds += 1

        # wait for player's response
        play_again = input("Play again? (yes/no): ")

        if play_again.lower() != "yes":
            break

play_game()