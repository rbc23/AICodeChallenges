```javascript
function generatePassword(length) {
  var charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+~`|}{[]\:;?><,./-=";
  var password = "";
  
  for (var i = 0; i < length; i++) {
    var randomIndex = Math.floor(Math.random() * charset.length);
    password += charset.charAt(randomIndex);
  }
  
  return password;
}

var passwordLength = prompt("Enter the length of the password:");
var password = generatePassword(passwordLength);

console.log("Generated Password: " + password);
```