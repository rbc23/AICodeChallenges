```python
def is_palindrome(string):
    string = string.lower()
    reversed_string = string[::-1]
    return string == reversed_string

input_string = input("Enter a string: ")

if is_palindrome(input_string):
    print("The string is a palindrome.")
else:
    print("The string is not a palindrome.")
```