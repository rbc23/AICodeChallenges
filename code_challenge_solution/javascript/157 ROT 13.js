let input = "Hello, this is a secret message.";

let output = "";

for (let i = 0; i < input.length; i++) {
  let charCode = input.charCodeAt(i);

  if (charCode >= 65 && charCode <= 90) {
    output += String.fromCharCode(((charCode - 65 + 13) % 26) + 65);
  } else if (charCode >= 97 && charCode <= 122) {
    output += String.fromCharCode(((charCode - 97 + 13) % 26) + 97);
  } else {
    output += input.charAt(i);
  }
}

console.log(output);