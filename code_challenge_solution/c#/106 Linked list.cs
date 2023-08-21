using System;

public class LinkedListNode<T>
{
    public T Value { get; set; }
    public LinkedListNode<T> Next { get; set; }
    
    public LinkedListNode(T value)
    {
        Value = value;
        Next = null;
    }
}

public class LinkedList<T>
{
    private LinkedListNode<T> head;
    
    public void Add(T value)
    {
        LinkedListNode<T> newNode = new LinkedListNode<T>(value);
        
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            LinkedListNode<T> currentNode = head;
            
            while (currentNode.Next != null)
            {
                currentNode = currentNode.Next;
            }
            
            currentNode.Next = newNode;
        }
    }
    
    public void Print()
    {
        LinkedListNode<T> currentNode = head;
        
        while (currentNode != null)
        {
            Console.Write(currentNode.Value + " ");
            currentNode = currentNode.Next;
        }
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        LinkedList<int> myList = new LinkedList<int>();
        
        myList.Add(10);
        myList.Add(20);
        myList.Add(30);
        
        myList.Print(); // Output: 10 20 30
    }
}