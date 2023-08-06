Here is the JavaScript code to validate username or password credentials:

```javascript
function validateCredentials(username, password) {
  // Validate username and password length
  if (username.length < 6 || username.length > 20 || password.length < 8 || password.length > 20) {
    return false;
  }

  // Validate username and password format
  var usernameRegex = /^[a-zA-Z0-9_]+$/;
  var passwordRegex = /^[a-zA-Z0-9!@#$%^&*]+$/;
  if (!usernameRegex.test(username) || !passwordRegex.test(password)) {
    return false;
  }

  // All validations passed, return true
  return true;
}

// Testing the validateCredentials function
var username = "johndoe123";
var password = "password123";
console.log(validateCredentials(username, password)); // Output: true

username = "admin*";
password = "12345678";
console.log(validateCredentials(username, password)); // Output: false
```