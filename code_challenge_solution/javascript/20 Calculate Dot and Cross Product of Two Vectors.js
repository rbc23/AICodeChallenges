const vector1 = [2, 4, 6];
const vector2 = [1, 3, 5];

// Calculate dot product
let dotProduct = 0;
for (let i = 0; i < vector1.length; i++) {
    dotProduct += vector1[i] * vector2[i];
}

// Calculate cross product
const crossProduct = [
    vector1[1] * vector2[2] - vector1[2] * vector2[1],
    vector1[2] * vector2[0] - vector1[0] * vector2[2],
    vector1[0] * vector2[1] - vector1[1] * vector2[0]
];

console.log("Dot Product: " + dotProduct);
console.log("Cross Product: " + JSON.stringify(crossProduct));