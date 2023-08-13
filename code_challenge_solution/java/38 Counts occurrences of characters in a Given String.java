let str = "Hello, World!";
let charCount = {};

for (let i = 0; i < str.length; i++) {
  let char = str[i];

  if (charCount[char]) {
    charCount[char]++;
  } else {
    charCount[char] = 1;
  }
}

for (let char in charCount) {
  console.log("'" + char + "' occurs " + charCount[char] + " times");
}