const vector1 = [1, 2, 3];
const vector2 = [4, 5, 6];

// Dot product
const dotProduct = vector1.reduce((sum, num, i) => sum + num * vector2[i], 0);

// Cross product
const crossProduct = [
  vector1[1] * vector2[2] - vector1[2] * vector2[1],
  vector1[2] * vector2[0] - vector1[0] * vector2[2],
  vector1[0] * vector2[1] - vector1[1] * vector2[0]
];

console.log("Dot Product:", dotProduct);
console.log("Cross Product:", crossProduct);