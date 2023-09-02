class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
  }

  isEmpty() {
    return this.head === null;
  }

  append(data) {
    const newNode = new Node(data);

    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

  prepend(data) {
    const newNode = new Node(data);

    if (!this.isEmpty()) {
      newNode.next = this.head;
    }

    this.head = newNode;

    if (!this.tail) {
      this.tail = newNode;
    }
  }

  deleteFirst() {
    if (this.isEmpty()) {
      return;
    }

    this.head = this.head.next;

    if (!this.head) {
      this.tail = null;
    }
  }

  deleteLast() {
    if (this.isEmpty()) {
      return;
    }

    if (this.head === this.tail) {
      this.head = null;
      this.tail = null;
      return;
    }

    let currentNode = this.head;
    while (currentNode.next !== this.tail) {
      currentNode = currentNode.next;
    }

    currentNode.next = null;
    this.tail = currentNode;
  }

  search(value) {
    let currentNode = this.head;

    while (currentNode) {
      if (currentNode.data === value) {
        return currentNode;
      }
      currentNode = currentNode.next;
    }

    return null;
  }

  delete(value) {
    if (this.isEmpty()) {
      return;
    }

    if (this.head.data === value) {
      this.deleteFirst();
      return;
    }

    let currentNode = this.head;

    while (currentNode.next) {
      if (currentNode.next.data === value) {
        currentNode.next = currentNode.next.next;
        if (currentNode.next === null) {
          this.tail = currentNode;
        }
        return;
      }
      currentNode = currentNode.next;
    }
  }

  display() {
    let currentNode = this.head;
    const elements = [];

    while (currentNode) {
      elements.push(currentNode.data);
      currentNode = currentNode.next;
    }

    return elements.join(' -> ');
  }
}

// Example usage:

const linkedList = new LinkedList();

linkedList.append(1);
linkedList.append(2);
linkedList.append(3);
linkedList.prepend(0);
linkedList.prepend(-1);
linkedList.deleteFirst();
linkedList.deleteLast();
linkedList.delete(2);

console.log(linkedList.display());  // Output: -1 -> 0 -> 1