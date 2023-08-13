let fibonacciSequence = [0, 1];
let n = 10;

for (let i = 2; i < n; i++) {
  fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
}

console.log(fibonacciSequence);