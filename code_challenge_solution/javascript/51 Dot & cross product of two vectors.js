// Dot product of two vectors
function dotProduct(vector1, vector2) {
  var result = 0;
  for (var i = 0; i < vector1.length; i++) {
    result += vector1[i] * vector2[i];
  }
  return result;
}

// Cross product of two vectors
function crossProduct(vector1, vector2) {
  if (vector1.length !== 3 || vector2.length !== 3) {
    throw new Error("Both vectors must be of length 3 for cross product calculation.");
  }
  
  var result = [];
  result[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
  result[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
  result[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];
  
  return result;
}