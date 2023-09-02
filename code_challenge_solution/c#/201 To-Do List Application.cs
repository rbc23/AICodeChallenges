using System;
using System.Collections.Generic;

namespace ToDoListApp
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> toDoList = new List<string>();

            while (true)
            {
                Console.Clear();
                Console.WriteLine("To-Do List App");
                Console.WriteLine("------------------");
                Console.WriteLine();
                Console.WriteLine("1. Add Task");
                Console.WriteLine("2. View Tasks");
                Console.WriteLine("3. Mark Task as Completed");
                Console.WriteLine("4. Delete Task");
                Console.WriteLine("5. Exit");
                Console.WriteLine();
                Console.Write("Enter your choice (1-5): ");
                string choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        Console.Clear();
                        Console.Write("Enter task description: ");
                        string task = Console.ReadLine();
                        toDoList.Add(task);
                        Console.WriteLine("Task added successfully!");
                        Console.ReadLine();
                        break;
                    case "2":
                        Console.Clear();
                        Console.WriteLine("To-Do List:");
                        Console.WriteLine("------------------");
                        if (toDoList.Count == 0)
                        {
                            Console.WriteLine("No tasks found.");
                        }
                        else
                        {
                            for (int i = 0; i < toDoList.Count; i++)
                            {
                                Console.WriteLine($"{i+1}. {toDoList[i]}");
                            }
                        }
                        Console.ReadLine();
                        break;
                    case "3":
                        Console.Clear();
                        Console.WriteLine("To-Do List:");
                        Console.WriteLine("------------------");
                        if (toDoList.Count == 0)
                        {
                            Console.WriteLine("No tasks found.");
                        }
                        else
                        {
                            for (int i = 0; i < toDoList.Count; i++)
                            {
                                Console.WriteLine($"{i+1}. {toDoList[i]}");
                            }
                            Console.WriteLine();
                            Console.Write("Enter the number of the task to mark as completed: ");
                            int taskNumber = Convert.ToInt32(Console.ReadLine());
                            if (taskNumber < 1 || taskNumber > toDoList.Count)
                            {
                                Console.WriteLine("Invalid task number.");
                            }
                            else
                            {
                                toDoList.RemoveAt(taskNumber - 1);
                                Console.WriteLine("Task marked as completed!");
                            }
                        }
                        Console.ReadLine();
                        break;
                    case "4":
                        Console.Clear();
                        Console.WriteLine("To-Do List:");
                        Console.WriteLine("------------------");
                        if (toDoList.Count == 0)
                        {
                            Console.WriteLine("No tasks found.");
                        }
                        else
                        {
                            for (int i = 0; i < toDoList.Count; i++)
                            {
                                Console.WriteLine($"{i+1}. {toDoList[i]}");
                            }
                            Console.WriteLine();
                            Console.Write("Enter the number of the task to delete: ");
                            int taskNumber = Convert.ToInt32(Console.ReadLine());
                            if (taskNumber < 1 || taskNumber > toDoList.Count)
                            {
                                Console.WriteLine("Invalid task number.");
                            }
                            else
                            {
                                toDoList.RemoveAt(taskNumber - 1);
                                Console.WriteLine("Task deleted successfully!");
                            }
                        }
                        Console.ReadLine();
                        break;
                    case "5":
                        Console.WriteLine("Goodbye!");
                        Environment.Exit(0);
                        break;
                    default:
                        Console.WriteLine("Invalid choice.");
                        Console.ReadLine();
                        break;
                }
            }
        }
    }
}