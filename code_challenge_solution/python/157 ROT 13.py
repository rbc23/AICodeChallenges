```python
def rot13(text):
    result = ""
    for char in text:
        if char.isalpha():
            if char.isupper():
                result += chr((ord(char) - 65 + 13) % 26 + 65)
            else:
                result += chr((ord(char) - 97 + 13) % 26 + 97)
        else:
            result += char
    return result

text = input("Enter text: ")
print("ROT13: ", rot13(text))
```