string = "Hello, World!"

def count_characters(string):
    freq = {}
    for char in string:
        if char in freq:
            freq[char] += 1
        else:
            freq[char] = 1
    return freq

print(count_characters(string))