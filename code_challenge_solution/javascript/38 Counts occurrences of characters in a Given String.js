let str = "Hello World!";
let charFrequency = {};

for (let i = 0; i < str.length; i++) {
  let char = str.charAt(i);
  if (charFrequency[char]) {
    charFrequency[char]++;
  } else {
    charFrequency[char] = 1;
  }
}

console.log(charFrequency);