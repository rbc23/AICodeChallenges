def pascals_triangle(num_rows):
    triangle = []
    for row in range(num_rows):
        curr_row = []
        for col in range(row + 1):
            if col == 0 or col == row:
                curr_row.append(1)
            else:
                curr_row.append(triangle[row-1][col-1] + triangle[row-1][col])
        triangle.append(curr_row)
    return triangle

num_rows = int(input("Enter the number of rows: "))
triangle = pascals_triangle(num_rows)
for row in triangle:
    print(row)