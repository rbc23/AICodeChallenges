name = input("Enter your name: ")
age = input("Enter your age: ")
occupation = input("Enter your occupation: ")
editor = input("Enter your preferred editor: ")
os = input("Enter your preferred operating system: ")
quote = input("Enter your favorite quote: ")

geekcode = f"GCS/IT/G/GC d-- s+:++ a C++ UL P L+++ E--- W+++ N+ o-- K- w O- M+ V- PS+ PE Y+ PGP t+++ 5 X++ R+++ tv b++ DI++ D++ G++ e++ h--- r++ z"

signature = f"-----BEGIN GEEK CODE BLOCK-----\nVersion: 3.1\n\n{geekcode}\n\nName: {name}\nAge: {age}\nOccupation: {occupation}\nPreferred Editor: {editor}\nPreferred OS: {os}\nFavorite Quote: {quote}\n-----END GEEK CODE BLOCK-----"

print(signature)