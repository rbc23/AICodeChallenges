# Method 1: Using slicing [::-1]
def reverse_string(string):
    return string[::-1]

# Method 2: Using a loop
def reverse_string(string):
    reversed_string = ""
    for char in string:
        reversed_string = char + reversed_string
    return reversed_string

# Method 3: Using the reversed() function
def reverse_string(string):
    return "".join(reversed(string))

# Method 4: Using recursion
def reverse_string(string):
    if len(string) == 0:
        return ""
    else:
        return reverse_string(string[1:]) + string[0]