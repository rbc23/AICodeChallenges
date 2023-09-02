print("Love Calculator")

name1 = input("Enter your name: ")
name2 = input("Enter your partner's name: ")

combined_name = name1 + name2

# Count the number of unique letters in the combined names
unique_letters = len(set(combined_name.lower()))

love_percentage = unique_letters * 10

print("Love Percentage:", love_percentage, "%")