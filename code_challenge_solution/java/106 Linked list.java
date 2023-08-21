
public class LinkedList {

    private Node head;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
        } else {
            Node current = head;
            Node prev = null;

            while (current != null && current.data != data) {
                prev = current;
                current = current.next;
            }

            if (current != null) {
                prev.next = current.next;
            }
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        myList.insert(5);
        myList.insert(10);
        myList.insert(15);
        myList.insert(20);

        myList.display();

        myList.delete(10);

        myList.display();
    }
}
