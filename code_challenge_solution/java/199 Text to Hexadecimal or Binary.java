console.log("Convert text to Hexadecimal or Binary:");

let text = "Hello World!";
let hexadecimal = "";
let binary = "";

for (let i = 0; i < text.length; i++) {
  let hex = text.charCodeAt(i).toString(16);
  let bin = text.charCodeAt(i).toString(2);
  
  hexadecimal += hex.toUpperCase() + " ";
  binary += bin + " ";
}

console.log(`Text: ${text}`);
console.log(`Hexadecimal: ${hexadecimal}`);
console.log(`Binary: ${binary}`);