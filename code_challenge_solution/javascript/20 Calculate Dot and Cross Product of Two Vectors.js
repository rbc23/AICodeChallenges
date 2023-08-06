```javascript
// Function to calculate the dot product of two vectors
function calculateDotProduct(vector1, vector2) {
  var dotProduct = 0;
  for(var i = 0; i < vector1.length; i++) {
    dotProduct += vector1[i] * vector2[i];
  }
  return dotProduct;
}

// Function to calculate the cross product of two vectors
function calculateCrossProduct(vector1, vector2) {
  var crossProduct = [];
  crossProduct[0] = (vector1[1] * vector2[2]) - (vector1[2] * vector2[1]);
  crossProduct[1] = (vector1[2] * vector2[0]) - (vector1[0] * vector2[2]);
  crossProduct[2] = (vector1[0] * vector2[1]) - (vector1[1] * vector2[0]);
  return crossProduct;
}

// Example usage
var vector1 = [1, 2, 3];
var vector2 = [4, 5, 6];

console.log("Dot Product:", calculateDotProduct(vector1, vector2));
console.log("Cross Product:", calculateCrossProduct(vector1, vector2));
```