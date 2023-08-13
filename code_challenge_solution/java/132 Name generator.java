Here is a JavaScript code to generate random names:

```
function generateRandomName() {
  var adjectives = ['Big', 'Small', 'Funny', 'Crazy', 'Smart', 'Happy'];
  var nouns = ['Dog', 'Cat', 'Elephant', 'Monkey', 'Lion', 'Turtle'];

  var randomAdjectiveIndex = Math.floor(Math.random() * adjectives.length);
  var randomNounIndex = Math.floor(Math.random() * nouns.length);

  var randomAdjective = adjectives[randomAdjectiveIndex];
  var randomNoun = nouns[randomNounIndex];

  var randomName = randomAdjective + ' ' + randomNoun;

  return randomName;
}

console.log(generateRandomName());
```

This code defines an array of adjectives and an array of nouns. It then generates random indexes for both arrays using `Math.random()` and `Math.floor()`. The corresponding random adjective and noun are then concatenated to form a random name. The function `generateRandomName()` returns the random name, and it is printed to the console using `console.log()`.