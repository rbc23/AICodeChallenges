# Function to generate Fibonacci sequence
def generate_fibonacci_sequence(n):
    sequence = []
    if n == 0:
        return sequence
    elif n == 1:
        sequence.append(0)
        return sequence
    elif n == 2:
        sequence.append(0)
        sequence.append(1)
        return sequence
    else:
        sequence.append(0)
        sequence.append(1)
        for i in range(2, n):
            sequence.append(sequence[i-1] + sequence[i-2])
        return sequence

# Test the function
n = int(input("Enter the number of terms in the Fibonacci sequence: "))
fibonacci_sequence = generate_fibonacci_sequence(n)
print("Fibonacci Sequence:", fibonacci_sequence)