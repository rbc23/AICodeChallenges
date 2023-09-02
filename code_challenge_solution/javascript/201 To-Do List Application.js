let todoList = [];

function displayMenu() {
  console.log("To-Do List Application");
  console.log("1. Add task");
  console.log("2. Complete task");
  console.log("3. View tasks");
  console.log("4. Exit");
}

function addTask() {
  let task = prompt("Enter task:");
  todoList.push(task);
  console.log("Task added successfully!");
}

function completeTask() {
  let taskIndex = prompt("Enter task index:");
  if (taskIndex >= 0 && taskIndex < todoList.length) {
    todoList.splice(taskIndex, 1);
    console.log("Task completed successfully!");
  } else {
    console.log("Invalid task index!");
  }
}

function viewTasks() {
  console.log("Tasks:");
  for (let i = 0; i < todoList.length; i++) {
    console.log(`${i}. ${todoList[i]}`);
  }
}

function start() {
  let choice = 0;
  while (choice != 4) {
    displayMenu();
    choice = prompt("Enter your choice:");
    switch (choice) {
      case "1":
        addTask();
        break;
      case "2":
        completeTask();
        break;
      case "3":
        viewTasks();
        break;
      case "4":
        console.log("Exiting...");
        break;
      default:
        console.log("Invalid choice!");
    }
    console.log("");
  }
}

start();