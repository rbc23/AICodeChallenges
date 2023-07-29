def generate_pascal_triangle(num_rows):
    triangle = []
    for i in range(num_rows):
        row = [1] * (i + 1)
        if i > 1:
            for j in range(1, i):
                row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
        triangle.append(row)
    return triangle

num_rows = int(input("Enter the number of rows: "))
pascal_triangle = generate_pascal_triangle(num_rows)
for row in pascal_triangle:
    print(row)