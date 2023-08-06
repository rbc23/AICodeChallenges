class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    // Add element to the end of the list
    add(data) {
        const newNode = new Node(data);

        if (this.head === null) {
            this.head = newNode;
        } else {
            let current = this.head;

            while (current.next) {
                current = current.next;
            }

            current.next = newNode;
        }

        this.size++;
    }

    // Insert element at a specific position
    insertAt(data, index) {
        if (index < 0 || index > this.size) {
            return false;
        }

        const newNode = new Node(data);

        if (index === 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            let current = this.head;
            let prev = null;
            let i = 0;

            while (i < index) {
                prev = current;
                current = current.next;
                i++;
            }

            newNode.next = current;
            prev.next = newNode;
        }

        this.size++;
        return true;
    }

    // Remove element from a specific position
    removeAt(index) {
        if (index < 0 || index >= this.size) {
            return null;
        }

        let current = this.head;
        let prev = null;
        let i = 0;

        if (index === 0) {
            this.head = current.next;
        } else {
            while (i < index) {
                prev = current;
                current = current.next;
                i++;
            }

            prev.next = current.next;
        }

        this.size--;
        return current.data;
    }

    // Remove element by value
    removeElement(data) {
        let current = this.head;
        let prev = null;

        while (current) {
            if (current.data === data) {
                if (prev === null) {
                    this.head = current.next;
                } else {
                    prev.next = current.next;
                }

                this.size--;
                return current.data;
            }

            prev = current;
            current = current.next;
        }

        return null;
    }

    // Get size of the list
    getSize() {
        return this.size;
    }

    // Check if the list is empty
    isEmpty() {
        return this.size === 0;
    }

    // Print the list
    printList() {
        let current = this.head;
        let result = '';

        while (current) {
            result += current.data + ' ';
            current = current.next;
        }

        console.log(result);
    }
}

// Example usage
const list = new LinkedList();

list.add(1);
list.add(2);
list.add(3);

list.printList(); // Output: 1 2 3

list.insertAt(4, 1);

list.printList(); // Output: 1 4 2 3

list.removeAt(2);

list.printList(); // Output: 1 4 3

list.removeElement(4);

list.printList(); // Output: 1 3

console.log(list.getSize()); // Output: 2

console.log(list.isEmpty()); // Output: false