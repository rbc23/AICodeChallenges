# Dot Product Calculation
def dot_product(vector1, vector2):
    result = 0
    for i in range(len(vector1)):
        result += vector1[i] * vector2[i]
    return result

# Cross Product Calculation
def cross_product(vector1, vector2):
    result = []
    result.append(vector1[1] * vector2[2] - vector1[2] * vector2[1])
    result.append(vector1[2] * vector2[0] - vector1[0] * vector2[2])
    result.append(vector1[0] * vector2[1] - vector1[1] * vector2[0])
    return result

# Testing the functions
vector1 = [3, 4, 5]
vector2 = [1, 2, 3]
print("Dot Product:", dot_product(vector1, vector2))
print("Cross Product:", cross_product(vector1, vector2))