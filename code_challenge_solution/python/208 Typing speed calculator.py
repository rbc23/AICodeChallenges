import time

def calculate_typing_speed():
    start_time = time.time()
    text = input("Type the following text:\n")
    end_time = time.time()

    num_chars = len(text)
    num_words = len(text.split())
    time_taken = end_time - start_time

    speed_cpm = (num_chars / time_taken) * 60
    speed_wpm = (num_words / time_taken) * 60

    print("Typing speed:")
    print("Characters per minute:", speed_cpm)
    print("Words per minute:", speed_wpm)

if __name__ == "__main__":
    calculate_typing_speed()