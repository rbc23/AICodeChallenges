```javascript
// Name generator function
function generateName() {
  const vowels = ['a', 'e', 'i', 'o', 'u'];
  const consonants = ['b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'];
  const nameLength = Math.floor(Math.random() * 5) + 3; // Random name length between 3 and 7
  let name = '';

  for (let i = 0; i < nameLength; i++) {
    if (i % 2 === 0) {
      name += consonants[Math.floor(Math.random() * consonants.length)];
    } else {
      name += vowels[Math.floor(Math.random() * vowels.length)];
    }
  }

  return name;
}

// Generate a random name
const randomName = generateName();
console.log(randomName);
```
This will generate a random name with a length between 3 and 7 characters, alternating between a consonant and a vowel.