Here is the JavaScript code to implement a random name picker:

```javascript
function randomNamePicker(names) {
  if (names.length === 0) {
    return "No names found.";
  }
  
  var randomIndex = Math.floor(Math.random() * names.length);
  var randomName = names[randomIndex];
  
  return randomName;
}

var names = ["John", "Jane", "Alice", "Bob"];
var randomName = randomNamePicker(names);

console.log("Random name: " + randomName);
```
Note: The code assumes that the `names` array contains the list of names from which the random name will be picked. You can replace the `names` array with your own list of names or modify the code to accept user input for the names.