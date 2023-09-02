import random

def hangman():
    words = ['python', 'programming', 'code', 'hangman', 'computer', 'game']
    word = random.choice(words)
    guessed_letters = []
    attempts = 6

    while True:
        hidden_word = ''
        for letter in word:
            if letter in guessed_letters:
                hidden_word += letter
            else:
                hidden_word += '_ '

        print(f"\n{hidden_word}")

        if hidden_word == word:
            print("Congratulations! You guessed the word.")
            break

        guess = input("Guess a letter: ").lower()

        if guess.isalpha() and len(guess) == 1:
            if guess in guessed_letters:
                print("You already guessed that letter.")
            elif guess in word:
                print("Correct guess!")
                guessed_letters.append(guess)
            else:
                attempts -= 1
                print("Wrong guess.")
                if attempts == 0:
                    print("Game over! You ran out of attempts.")
                    break
        else:
            print("Invalid guess. Please enter a single letter.")

hangman()