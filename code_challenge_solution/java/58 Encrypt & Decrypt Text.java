Here is the Javascript code to encrypt and decrypt text:

```javascript
// Encryption function
function encryptText(text, key) {
  let encryptedText = "";
  for (let i = 0; i < text.length; i++) {
    let charCode = text.charCodeAt(i);
    let encryptedCharCode = (charCode + key) % 128;
    encryptedText += String.fromCharCode(encryptedCharCode);
  }
  return encryptedText;
}
  
// Decryption function
function decryptText(encryptedText, key) {
  let decryptedText = "";
  for (let i = 0; i < encryptedText.length; i++) {
    let charCode = encryptedText.charCodeAt(i);
    let decryptedCharCode = (charCode - key + 128) % 128;
    decryptedText += String.fromCharCode(decryptedCharCode);
  }
  return decryptedText;
}
  
// Test
let message = "Hello, World!";
let key = 5;

let encryptedMessage = encryptText(message, key);
console.log("Encrypted Message:", encryptedMessage);

let decryptedMessage = decryptText(encryptedMessage, key);
console.log("Decrypted Message:", decryptedMessage);
```

This code defines two functions: `encryptText()` and `decryptText()`. The `encryptText()` function takes a string of text and a key as input and returns the encrypted text by shifting each character's char code by the key value. The `decryptText()` function takes the encrypted text and the same key value as input and returns the decrypted text by reversing the encryption process. Finally, the code tests the encryption and decryption functions by encrypting the message "Hello, World!" with a key of 5, and then decrypting the encrypted message using the same key.