```python
class TodoList:
    def __init__(self):
        self.tasks = []

    def add_task(self, task):
        self.tasks.append(task)

    def remove_task(self, task):
        self.tasks.remove(task)

    def get_tasks(self):
        return self.tasks

    def clear_tasks(self):
        self.tasks.clear()


def main():
    todo_list = TodoList()

    print("To-Do List App\n")

    while True:
        print("Select an option:")
        print("1. Add a task")
        print("2. Remove a task")
        print("3. View tasks")
        print("4. Clear all tasks")
        print("5. Exit")

        choice = input("Enter your choice: ")

        if choice == "1":
            task = input("Enter task: ")
            todo_list.add_task(task)
            print("Task added successfully!\n")

        elif choice == "2":
            task = input("Enter task to remove: ")
            try:
                todo_list.remove_task(task)
                print("Task removed successfully!\n")
            except ValueError as e:
                print("Task not found!\n")

        elif choice == "3":
            tasks = todo_list.get_tasks()
            if len(tasks) == 0:
                print("No tasks found!\n")
            else:
                print("Tasks:")
                for i, task in enumerate(tasks, start=1):
                    print(f"{i}. {task}")
                print()

        elif choice == "4":
            todo_list.clear_tasks()
            print("All tasks cleared!\n")

        elif choice == "5":
            print("Exiting the program...")
            break

        else:
            print("Invalid choice! Please try again.\n")


if __name__ == "__main__":
    main()
```