import time

def print_ascii_clock():
    digits = {
        0: ["███",
            "█ █",
            "█ █",
            "█ █",
            "███"],
        1: ["██ ",
            " █ ",
            " █ ",
            " █ ",
            "███"],
        2: ["███",
            "  █",
            "███",
            "█  ",
            "███"],
        3: ["███",
            "  █",
            "███",
            "  █",
            "███"],
        4: ["█ █",
            "█ █",
            "███",
            "  █",
            "  █"],
        5: ["███",
            "█  ",
            "███",
            "  █",
            "███"],
        6: ["███",
            "█  ",
            "███",
            "█ █",
            "███"],
        7: ["███",
            "  █",
            "  █",
            "  █",
            "  █"],
        8: ["███",
            "█ █",
            "███",
            "█ █",
            "███"],
        9: ["███",
            "█ █",
            "███",
            "  █",
            "███"]
    }

    while True:
        current_time = time.strftime("%H:%M:%S")
        digits_to_print = []

        for digit_str in current_time.replace(":", ""):
            digit_int = int(digit_str)
            digits_to_print.append(digits[digit_int])

        for line in range(5):
            for digit in digits_to_print:
                print(digit[line], end="  ")
            print()

        time.sleep(1)
        print("\033c", end="")  # clear the terminal

print_ascii_clock()