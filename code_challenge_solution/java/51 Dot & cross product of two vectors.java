let vector1 = [1, 2, 3];
let vector2 = [4, 5, 6];

// Dot product calculation
let dotProduct = vector1[0] * vector2[0] + vector1[1] * vector2[1] + vector1[2] * vector2[2];

// Cross product calculation
let crossProduct = [
  vector1[1] * vector2[2] - vector1[2] * vector2[1],
  vector1[2] * vector2[0] - vector1[0] * vector2[2],
  vector1[0] * vector2[1] - vector1[1] * vector2[0]
];

console.log("Dot product:", dotProduct);
console.log("Cross product:", crossProduct);