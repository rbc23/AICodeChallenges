class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
    
class LinkedList:
    def __init__(self):
        self.head = None
    
    def append(self, data):
        new_node = Node(data)
        
        if not self.head:
            self.head = new_node
        else:
            curr_node = self.head
            while curr_node.next:
                curr_node = curr_node.next
            curr_node.next = new_node
    
    def prepend(self, data):
        new_node = Node(data)
        
        new_node.next = self.head
        self.head = new_node
    
    def delete(self, data):
        if not self.head:
            return
        
        if self.head.data == data:
            self.head = self.head.next
            return
        
        curr_node = self.head
        next_node = curr_node.next
        
        while next_node:
            if next_node.data == data:
                curr_node.next = next_node.next
                return
            curr_node = next_node
            next_node = next_node.next
    
    def print_list(self):
        if not self.head:
            print("Linked list is empty")
            return
        
        curr_node = self.head
        while curr_node:
            print(curr_node.data, end=" ")
            curr_node = curr_node.next
        
        print()