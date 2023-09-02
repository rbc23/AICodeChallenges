```csharp
using System;

public class Node
{
    public int data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
        next = null;
    }
}

public class LinkedList
{
    private Node head;

    public void Insert(int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Node current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void Display()
    {
        Node current = head;
        while (current != null)
        {
            Console.Write(current.data + " ");
            current = current.next;
        }
        Console.WriteLine();
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        LinkedList linkedList = new LinkedList();

        linkedList.Insert(1);
        linkedList.Insert(2);
        linkedList.Insert(3);
        linkedList.Insert(4);
        linkedList.Insert(5);

        linkedList.Display();
    }
}
```