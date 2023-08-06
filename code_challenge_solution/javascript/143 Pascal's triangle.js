let numRows = 5; // Define the number of rows in Pascal's triangle

// Function to generate Pascal's triangle
function generatePascalsTriangle(numRows) {
  let triangle = [];
  
  for (let i = 0; i < numRows; i++) {
    triangle[i] = [];
    triangle[i][0] = 1;
    triangle[i][i] = 1;
    
    for (let j = 1; j < i; j++) {
      triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
    }
  }
  
  return triangle;
}

// Generate Pascal's triangle
let pascalsTriangle = generatePascalsTriangle(numRows);

// Display Pascal's triangle
for (let i = 0; i < numRows; i++) {
  let row = "";
  for (let j = 0; j <= i; j++) {
    row += pascalsTriangle[i][j] + " ";
  }
  console.log(row);
}