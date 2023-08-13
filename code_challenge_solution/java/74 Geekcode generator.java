```javascript
function generateGeekcodeSignature(name, age, favoriteLanguage, favoriteDrink) {
  var geekcode = "";
  
  // Name: [Your Name]
  geekcode += "Name: " + name + "\n";
  
  // Age: [Your Age]
  geekcode += "Age: " + age + "\n";
  
  // Favorite Language: [Your Favorite Programming Language]
  geekcode += "Favorite Language: " + favoriteLanguage + "\n";
  
  // Favorite Drink: [Your Favorite Drink]
  geekcode += "Favorite Drink: " + favoriteDrink;
  
  return geekcode;
}

// Example usage
var name = "John Doe";
var age = 25;
var favoriteLanguage = "JavaScript";
var favoriteDrink = "Coffee";

var geekcodeSignature = generateGeekcodeSignature(name, age, favoriteLanguage, favoriteDrink);
console.log(geekcodeSignature);
```
