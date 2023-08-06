```javascript
// Function to generate a random password
function generatePassword(length) {
  var charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+{}:<>?|-=[];,.";

  var password = "";
  for (var i = 0; i < length; i++) {
    var randomIndex = Math.floor(Math.random() * charset.length);
    password += charset.charAt(randomIndex);
  }

  return password;
}

// Function to generate a random passphrase
function generatePassphrase(wordsCount) {
  var wordlist = [
    "apple", "banana", "cherry", "orange", "mango", "watermelon", "pineapple", "strawberry", "grape", "kiwi",
    "football", "basketball", "baseball", "soccer", "tennis", "golf", "hockey", "rugby", "cricket", "volleyball",
    "sun", "moon", "star", "cloud", "rain", "snow", "wind", "thunder", "lightning", "rainbow",
    "cat", "dog", "bird", "fish", "rabbit", "hamster", "turtle", "snake", "elephant", "lion"
  ];

  var passphrase = "";
  for (var i = 0; i < wordsCount; i++) {
    var randomIndex = Math.floor(Math.random() * wordlist.length);
    passphrase += wordlist[randomIndex] + " ";
  }

  return passphrase.trim();
}

// Generate a random password with length 8
var password = generatePassword(8);
console.log("Random Password:", password);

// Generate a random passphrase with 4 words
var passphrase = generatePassphrase(4);
console.log("Random Passphrase:", passphrase);
```
