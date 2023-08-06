Here is the javascript code to generate a Geekcode signature:

```
function generateGeekcode(name, age, occupation, operatingSystem, programmingLanguages) {
  var geekcode = "-----BEGIN GEEK CODE BLOCK-----\n";
  geekcode += "Version: 3.1\n";
  geekcode += "Name: " + name + "\n";
  geekcode += "Age: " + age + "\n";
  geekcode += "Occupation: " + occupation + "\n";
  geekcode += "Operating System: " + operatingSystem + "\n";
  geekcode += "Languages: " + programmingLanguages.join(", ") + "\n";
  geekcode += "-----END GEEK CODE BLOCK-----\n";

  return geekcode;
}

// Example usage:
var name = "John Doe";
var age = 25;
var occupation = "Software Developer";
var operatingSystem = "Linux";
var programmingLanguages = ["JavaScript", "Python", "Java"];

var geekcodeSignature = generateGeekcode(name, age, occupation, operatingSystem, programmingLanguages);
console.log(geekcodeSignature);
```

Note: Replace the example values with your own data.