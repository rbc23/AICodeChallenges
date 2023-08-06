JavaScript Code:

// Encrypt Function
function encryptText(text, key) {
  let encrypted = "";
  for (let i = 0; i < text.length; i++) {
    let asciiValue = text.charCodeAt(i);
    let encryptedValue = asciiValue + key;
    encrypted += String.fromCharCode(encryptedValue);
  }
  return encrypted;
}

// Decrypt Function
function decryptText(encryptedText, key) {
  let decrypted = "";
  for (let i = 0; i < encryptedText.length; i++) {
    let asciiValue = encryptedText.charCodeAt(i);
    let decryptedValue = asciiValue - key;
    decrypted += String.fromCharCode(decryptedValue);
  }
  return decrypted;
}

// Example usage
let text = "Hello World!";
let key = 5;

let encryptedText = encryptText(text, key);
console.log("Encrypted Text: " + encryptedText);

let decryptedText = decryptText(encryptedText, key);
console.log("Decrypted Text: " + decryptedText);