```c++
#include <iostream>
#include <vector>
#include <string>

using namespace std;

void printMenu()
{
    cout << "To-Do List Application" << endl;
    cout << "---------------------" << endl;
    cout << "1. Add Item" << endl;
    cout << "2. Delete Item" << endl;
    cout << "3. View List" << endl;
    cout << "4. Exit" << endl;
    cout << "---------------------" << endl;
}

void addItem(vector<string>& list)
{
    cout << "Enter the item to add: ";
    string item;
    cin.ignore();
    getline(cin, item);
    list.push_back(item);
    cout << "Item added successfully!" << endl;
}

void deleteItem(vector<string>& list)
{
    if (list.empty())
    {
        cout << "The list is empty. No items to delete." << endl;
    }
    else
    {
        cout << "Enter the index of the item to delete (0-" << list.size() - 1 << "): ";
        int index;
        cin >> index;

        if (index < 0 || index >= list.size())
        {
            cout << "Invalid index. Please try again." << endl;
        }
        else
        {
            list.erase(list.begin() + index);
            cout << "Item deleted successfully!" << endl;
        }
    }
}

void viewList(const vector<string>& list)
{
    if (list.empty())
    {
        cout << "The list is empty." << endl;
    }
    else
    {
        cout << "To-Do List:" << endl;
        for (int i = 0; i < list.size(); i++)
        {
            cout << i << ". " << list[i] << endl;
        }
    }
}

int main()
{
    vector<string> todoList;
    int choice = 0;

    while (choice != 4)
    {
        printMenu();
        cout << "Enter your choice (1-4): ";
        cin >> choice;

        switch (choice)
        {
            case 1:
                addItem(todoList);
                break;
            case 2:
                deleteItem(todoList);
                break;
            case 3:
                viewList(todoList);
                break;
            case 4:
                cout << "Exiting the application. Goodbye!" << endl;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }

        cout << endl;
    }

    return 0;
}
```