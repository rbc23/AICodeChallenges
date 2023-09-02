```javascript
function generatePascalsTriangle(numRows) {
  let triangle = [];

  if (numRows === 0) {
    return triangle;
  }

  for (let i = 0; i < numRows; i++) {
    let row = [];
    for (let j = 0; j <= i; j++) {
      if (j === 0 || j === i) {
        row.push(1);
      } else {
        let prevRow = triangle[i - 1];
        let sum = prevRow[j - 1] + prevRow[j];
        row.push(sum);
      }
    }
    triangle.push(row);
  }

  return triangle;
}

console.log(generatePascalsTriangle(5));

```
Note: The parameter `numRows` indicates the number of rows in the triangle. Change the value of `numRows` to generate Pascal's triangle of different sizes.