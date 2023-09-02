```javascript
function generatePassword(length) {
  const lowercase = 'abcdefghijklmnopqrstuvwxyz';
  const uppercase = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
  const numbers = '0123456789';
  const specialChars = '!@#$%^&*()-_=+[]{}<>,.?/~`|';

  let characters = lowercase + uppercase + numbers + specialChars;

  let password = '';
  for (let i = 0; i < length; i++) {
    let randomIndex = Math.floor(Math.random() * characters.length);
    password += characters.charAt(randomIndex);
  }

  return password;
}

function generatePassphrase(words) {
  const dictionary = [
    'apple', 'banana', 'cat', 'dog', 'elephant', 'fish', 'gorilla', 'horse',
    'igloo', 'jellyfish', 'kangaroo', 'lemon', 'monkey', 'narwhal', 'octopus',
    'penguin', 'quail', 'rabbit', 'squirrel', 'tiger', 'unicorn', 'vulture',
    'walrus', 'xylophone', 'yak', 'zebra'
  ];

  let passphrase = '';
  for (let i = 0; i < words; i++) {
    let randomIndex = Math.floor(Math.random() * dictionary.length);
    passphrase += dictionary[randomIndex] + ' ';
  }

  return passphrase.trim();
}

// Usage:
console.log('Generated Password:', generatePassword(10));
console.log('Generated Passphrase:', generatePassphrase(4));
```
Note: The above code generates a password by combining lowercase, uppercase, numbers, and special characters. The generated password has a specified length. The code also generates a passphrase by randomly selecting words from a dictionary. The number of words in the passphrase can be specified.