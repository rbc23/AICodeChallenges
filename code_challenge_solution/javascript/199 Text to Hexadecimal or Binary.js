Here is the javascript code to convert text to hexadecimal or binary:

```
function textToHex(text) {
  let hex = "";
  for (let i = 0; i < text.length; i++) {
    let charCode = text.charCodeAt(i).toString(16);
    hex += ("00" + charCode).slice(-2) + " ";
  }
  return hex.trim();
}

function textToBinary(text) {
  let binary = "";
  for (let i = 0; i < text.length; i++) {
    let charCode = text.charCodeAt(i).toString(2);
    binary += ("00000000" + charCode).slice(-8) + " ";
  }
  return binary.trim();
}

let inputText = "Hello, World!";
console.log("Text: " + inputText);
console.log("Hexadecimal: " + textToHex(inputText));
console.log("Binary: " + textToBinary(inputText));
```