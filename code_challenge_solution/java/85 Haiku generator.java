Sure! Here is a simple implementation of a Haiku generator using JavaScript:

```javascript
// Function to generate a random integer within a specified range
function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}

// Function to generate a Haiku poem
function generateHaiku() {
  // Arrays of Haiku syllable patterns for each line
  var line1 = [5];
  var line2 = [7];
  var line3 = [5];

  // Array of possible words for each syllable pattern
  var words = {
    5: ["Autumn", "Blossoms", "Cherry", "Delicate", "Enlightenment"],
    7: ["Celebration", "Harmony", "Meditation", "Tranquility", "Whispering"],
  };

  // Generate the 1st line of Haiku
  var haikuLine1 = "";
  for (var i = 0; i < line1.length; i++) {
    var syllablePattern = line1[i];
    var randomIndex = getRandomInt(0, words[syllablePattern].length - 1);
    var word = words[syllablePattern][randomIndex];
    haikuLine1 += word + " ";
  }

  // Generate the 2nd line of Haiku
  var haikuLine2 = "";
  for (var i = 0; i < line2.length; i++) {
    var syllablePattern = line2[i];
    var randomIndex = getRandomInt(0, words[syllablePattern].length - 1);
    var word = words[syllablePattern][randomIndex];
    haikuLine2 += word + " ";
  }

  // Generate the 3rd line of Haiku
  var haikuLine3 = "";
  for (var i = 0; i < line3.length; i++) {
    var syllablePattern = line3[i];
    var randomIndex = getRandomInt(0, words[syllablePattern].length - 1);
    var word = words[syllablePattern][randomIndex];
    haikuLine3 += word + " ";
  }

  // Return the generated Haiku poem
  return haikuLine1.trim() + "\n" + haikuLine2.trim() + "\n" + haikuLine3.trim();
}

// Generate a Haiku poem
var haiku = generateHaiku();

// Print the Haiku poem
console.log(haiku);
```

Please note that this is just a basic implementation and the word lists can be expanded to include more options for each syllable pattern.