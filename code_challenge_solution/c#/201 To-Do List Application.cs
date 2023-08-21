using System;
using System.Collections.Generic;

namespace ToDoListApp
{
    class Program
    {
        static List<string> toDoList = new List<string>();

        static void Main(string[] args)
        {
            Console.WriteLine("To-Do List Application");
            Console.WriteLine("------------------------");

            bool running = true;

            while (running)
            {
                Console.WriteLine("\nPlease select an option:");
                Console.WriteLine("1. Add task");
                Console.WriteLine("2. Show tasks");
                Console.WriteLine("3. Mark task as complete");
                Console.WriteLine("4. Exit");

                Console.Write("Option: ");
                string option = Console.ReadLine();

                switch (option)
                {
                    case "1":
                        AddTask();
                        break;
                    case "2":
                        ShowTasks();
                        break;
                    case "3":
                        MarkTaskAsComplete();
                        break;
                    case "4":
                        running = false;
                        break;
                    default:
                        Console.WriteLine("Invalid option! Please try again.");
                        break;
                }
            }

            Console.WriteLine("\nThank you for using the To-Do List Application!");
        }

        static void AddTask()
        {
            Console.Write("\nEnter a task: ");
            string task = Console.ReadLine();

            toDoList.Add(task);

            Console.WriteLine("Task added successfully!");
        }

        static void ShowTasks()
        {
            Console.WriteLine("\nTasks:");

            if (toDoList.Count == 0)
            {
                Console.WriteLine("No tasks found");
            }
            else
            {
                for (int i = 0; i < toDoList.Count; i++)
                {
                    Console.WriteLine($"{i + 1}. {toDoList[i]}");
                }
            }
        }

        static void MarkTaskAsComplete()
        {
            Console.Write("\nEnter the task number to mark as complete: ");
            int taskNumber = Int32.Parse(Console.ReadLine());

            if (taskNumber > 0 && taskNumber <= toDoList.Count)
            {
                toDoList.RemoveAt(taskNumber - 1);
                Console.WriteLine("Task marked as complete!");
            }
            else
            {
                Console.WriteLine("Invalid task number! Please try again.");
            }
        }
    }
}