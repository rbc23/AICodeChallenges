// dot product function
function dotProduct(vector1, vector2) {
  if (vector1.length !== vector2.length) {
    throw new Error('Vectors must have the same length');
  }

  let dotProduct = 0;

  for (let i = 0; i < vector1.length; i++) {
    dotProduct += vector1[i] * vector2[i];
  }

  return dotProduct;
}

// cross product function
function crossProduct(vector1, vector2) {
  if (vector1.length !== 3 || vector2.length !== 3) {
    throw new Error('Both vectors must be of length 3 for cross product calculation');
  }

  const crossProduct = [
    vector1[1] * vector2[2] - vector1[2] * vector2[1],
    vector1[2] * vector2[0] - vector1[0] * vector2[2],
    vector1[0] * vector2[1] - vector1[1] * vector2[0]
  ];

  return crossProduct;
}

// example usage
const vector1 = [1, 2, 3];
const vector2 = [4, 5, 6];

console.log('Dot product:', dotProduct(vector1, vector2));
console.log('Cross product:', crossProduct(vector1, vector2));