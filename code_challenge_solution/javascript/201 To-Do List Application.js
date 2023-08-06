Sure, here is the javascript code to build a To-Do List Application:

```javascript
// Get DOM Elements
const form = document.getElementById('todo-form');
const input = document.getElementById('todo-input');
const list = document.getElementById('todo-list');

// Create an array to hold todo items
let todos = [];

// Function to render a single todo item
function renderTodoItem(todo) {
  const item = document.createElement('li');
  item.innerHTML = `<span>${todo}</span><button class="delete-btn">Delete</button>`;
  list.appendChild(item);
}

// Function to update the todos array and render all todo items
function updateTodos() {
  list.innerHTML = '';
  todos.forEach(renderTodoItem);
}

// Function to handle form submission
function handleFormSubmit(event) {
  event.preventDefault();
  const todoText = input.value;
  
  if (todoText.trim() !== '') {
    todos.push(todoText);
    input.value = '';
    updateTodos();
  }
}

// Function to handle delete button click
function handleDeleteClick(event) {
  if (event.target.classList.contains('delete-btn')) {
    const todoItem = event.target.parentElement;
    const todoText = todoItem.querySelector('span').textContent;
    const todoIndex = todos.indexOf(todoText);
    
    if (todoIndex > -1) {
      todos.splice(todoIndex, 1);
      todoItem.remove();
    }
  }
}

// Add event listeners
form.addEventListener('submit', handleFormSubmit);
list.addEventListener('click', handleDeleteClick);
```

You will also need the following HTML code to create the necessary elements for the To-Do List Application:

```html
<div id="todo-app">
  <h1>To-Do List</h1>
  <form id="todo-form">
    <input type="text" id="todo-input" placeholder="Enter a task">
    <button type="submit">Add</button>
  </form>
  <ul id="todo-list"></ul>
</div>
```

Feel free to customize the CSS or add additional features to the application as needed.