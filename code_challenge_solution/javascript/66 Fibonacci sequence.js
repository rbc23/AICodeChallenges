let num1 = 0;
let num2 = 1;
let sum = 0;

console.log(num1);
console.log(num2);

for(let i = 3; i <= 10; i++) {
    sum = num1 + num2;
    console.log(sum);
    num1 = num2;
    num2 = sum;
}