class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
  }

  append(value) {
    const newNode = new Node(value);

    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

  prepend(value) {
    const newNode = new Node(value);

    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  delete(value) {
    if (!this.head) {
      return;
    }

    while (this.head && this.head.value === value) {
      this.head = this.head.next;
    }

    let currentNode = this.head;

    while (currentNode.next) {
      if (currentNode.next.value === value) {
        currentNode.next = currentNode.next.next;
      } else {
        currentNode = currentNode.next;
      }
    }

    if (this.tail.value === value) {
      this.tail = currentNode;
    }
  }

  insertAfter(value, afterValue) {
    const newNode = new Node(value);
    let currentNode = this.head;

    while (currentNode) {
      if (currentNode.value === afterValue) {
        newNode.next = currentNode.next;
        currentNode.next = newNode;

        if (currentNode === this.tail) {
          this.tail = newNode;
        }

        break;
      }

      currentNode = currentNode.next;
    }
  }

  toArray() {
    const array = [];
    let currentNode = this.head;

    while (currentNode) {
      array.push(currentNode.value);
      currentNode = currentNode.next;
    }

    return array;
  }
}

class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

// Example usage:
const linkedList = new LinkedList();

linkedList.append(1);
linkedList.append(2);
linkedList.append(3);

console.log(linkedList.toArray()); // Output: [1, 2, 3]

linkedList.insertAfter(4, 2);

console.log(linkedList.toArray()); // Output: [1, 2, 4, 3]

linkedList.prepend(0);

console.log(linkedList.toArray()); // Output: [0, 1, 2, 4, 3]

linkedList.delete(1);

console.log(linkedList.toArray()); // Output: [0, 2, 4, 3]