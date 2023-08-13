Here's the JavaScript code for a basic To-Do List application:

```javascript
// Define the list container
const listContainer = document.getElementById('list-container');

// Define the input field and button
const inputField = document.getElementById('input-field');
const addButton = document.getElementById('add-button');

// Define the array to store the to-do items
const toDoItems = [];

// Function to add a new to-do item
const addItem = () => {
  // Get the input value
  const inputValue = inputField.value;

  // Add the item to the array
  toDoItems.push(inputValue);

  // Clear the input field
  inputField.value = '';

  // Refresh the list
  refreshList();
};

// Function to remove a to-do item
const removeItem = (index) => {
  // Remove the item from the array
  toDoItems.splice(index, 1);

  // Refresh the list
  refreshList();
};

// Function to refresh the to-do list
const refreshList = () => {
  // Clear the list container
  listContainer.innerHTML = '';

  // Loop through each item in the array
  for (let i = 0; i < toDoItems.length; i++) {
    // Create a new list item element
    const listItem = document.createElement('li');

    // Add the item text
    listItem.innerText = toDoItems[i];

    // Create a remove button
    const removeButton = document.createElement('button');
    removeButton.innerText = 'Remove';

    // Add an event listener to the remove button
    removeButton.addEventListener('click', () => {
      removeItem(i);
    });

    // Append the remove button to the list item
    listItem.appendChild(removeButton);

    // Append the list item to the list container
    listContainer.appendChild(listItem);
  }
};

// Add an event listener to the add button
addButton.addEventListener('click', addItem);
```

This code defines the necessary functions and event listeners for adding and removing items from the to-do list. It also provides a basic HTML structure with an input field, button, and list container. You can use this code as a starting point and customize it further as per your requirements.