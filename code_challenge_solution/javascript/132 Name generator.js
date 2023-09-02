```javascript
// Array of possible first names
const firstNames = ['John', 'Jane', 'David', 'Emily', 'Michael', 'Sarah', 'Christopher', 'Jessica', 'Matthew', 'Olivia'];

// Array of possible last names
const lastNames = ['Smith', 'Johnson', 'Brown', 'Jones', 'Miller', 'Davis', 'Garcia', 'Rodriguez', 'Wilson', 'Martinez'];

// Function to generate a random name
function generateRandomName() {
  const randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)];
  const randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];

  return randomFirstName + ' ' + randomLastName;
}

// Generate and display a random name
console.log(generateRandomName());
```