import time

def calculate_typing_speed(text, time_taken):
    words = text.split()
    num_words = len(words)
    words_per_minute = (num_words / time_taken) * 60
    return words_per_minute

def main():
    print("Typing Speed Calculator")
    print("Type the given text below and press Enter when you are done:")
    print("------------------------------------------------------------")

    # Replace the sample_text with the actual text you want to use for the typing test
    sample_text = "This is a sample text to test your typing speed. Try to type it as quickly and accurately as possible."

    print(sample_text)

    input("Press Enter when you are ready to start...")

    start_time = time.time()

    typed_text = input("Start typing: ")

    end_time = time.time()

    time_taken = end_time - start_time

    typing_speed = calculate_typing_speed(typed_text, time_taken)

    print("\nTime taken: {:.2f} seconds".format(time_taken))
    print("Typing Speed: {:.2f} words per minute (WPM)".format(typing_speed))

if __name__ == "__main__":
    main()
