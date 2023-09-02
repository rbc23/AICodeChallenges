```cpp
#include <iostream>

using namespace std;

// Node Class
class Node {
public:
    int data;
    Node* next;
};

// Linked List Class
class LinkedList {
private:
    Node* head;

public:
    LinkedList() {
        head = NULL;
    }

    // Insert a node at the beginning of the linked list
    void insertAtBeginning(int value) {
        Node* newNode = new Node();
        newNode->data = value;
        newNode->next = head;
        head = newNode;
    }

    // Insert a node at the end of the linked list
    void insertAtEnd(int value) {
        Node* newNode = new Node();
        newNode->data = value;
        newNode->next = NULL;

        // If list is empty, make the new node as head
        if (head == NULL) {
            head = newNode;
            return;
        }

        // Else traverse till the last node and insert the new node there
        Node* last = head;
        while (last->next != NULL) {
            last = last->next;
        }
        last->next = newNode;
    }

    // Print the linked list
    void printList() {
        Node* temp = head;
        while (temp != NULL) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }
};

int main() {
    LinkedList list;

    // Inserting nodes at the beginning
    list.insertAtBeginning(5);
    list.insertAtBeginning(3);
    list.insertAtBeginning(1);

    // Inserting nodes at the end
    list.insertAtEnd(7);
    list.insertAtEnd(9);

    // Printing the linked list
    list.printList();

    return 0;
}
```