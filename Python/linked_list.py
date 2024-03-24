class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next
        
class LinkedList:
    def __init__(self):
        self.head = None
    
    def insert_at_start(self, data):
        node = Node(data, self.head)
        self.head = node
    
    def insert_at_end(self, data):
        if self.head is None:
            self.head = Node(data, None)
            return
        itr = self.head
        while itr.next:
            itr = itr.next
        itr.next = Node(data, None)
            
    def insert_values(self, list):
        for data in list:
            self.insert_at_end(data)
    def print(self):
        if self.head is None:
            print("Sorry, Not existed")
            return
        
        itr = self.head
        while itr:
            print(itr.data)
            itr = itr.next
    def get_length(self):
        count = 0
        itr = self.head
        
        while itr:
            count +=1
            itr = itr.next
        return count
    
    def remove_at(self, index):
        if index<0 or index>=self.get_length():
            raise Exception("Invalid")
        if index == 0:
            self.head = self.head.next
            return
        
        count = 0
        itr = self.head
        while itr:
            if count == index-1:
                itr.next = itr.next.next
                break
            count +=1
            itr = itr.next
        
    def remove_by_value(self, value):
        if self.head is None:  # If the linked list is empty
         return

        if self.head.data == value:
            self.head = self.head.next
            return
        
        itr = self.head
        while itr:
            if itr.next.data == value:
                itr.next = itr.next.next
                break
            itr = itr.next
            
                
if __name__ == '__main__':
    ll = LinkedList()
    ll.insert_at_end(55)  
    ll.insert_at_end(2)  
    ll.insert_at_end(99)  
    ll.insert_at_end(57)  
    ll.print()
    ll.remove_by_value(57)
    ll.print()