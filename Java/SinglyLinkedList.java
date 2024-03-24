public class SinglyLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public Node head = null;
    public Node tail = null;

    public void display(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        Node temp = head;
        while(temp != null){
              System.out.println(temp.data);
              temp = temp.next;
        }

    }

    public  void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else{
            tail.next = newNode;
        }
        tail = newNode;
    }
    
    public void deleteNode(int data){
        Node temp = head, prev = null;
        if(temp != null && temp.data == data){
            head = temp.next;
            return;
        }
        while(temp != null && temp.data != data){
                prev = temp;
                temp = temp.next;
        }
        if(temp == null){
          System.out.println("Value Not find");
          return;
        }
        if(temp == tail){
            tail = prev;
            tail.next = null;
            return;
        }
        prev.next = temp.next;

    }

    public void insertAfter(int data, int nexTo){
        Node newNode = new Node(data);
        Node temp = head;

        while(temp != null && temp.data != nexTo){
            temp = temp.next;
        }
        if(temp == null){
           return;
        }
        if(temp == tail){
            tail.next = newNode;
            tail = newNode;
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
    public void sort() {
        Node temp = head;
        while (temp != null) {
            Node small = temp;
            Node x = temp.next;

            while (x != null) {
                if (x.data < small.data) {
                    small = x;
                }
                x = x.next;
            }
            int t = small.data;
            small.data = temp.data;
            temp.data = t;

            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addNode(220);
        list.addNode(50);
        list.addNode(3);
        list.addNode(20);
        list.deleteNode(20);
        list.insertAfter(99 , 50);
        list.sort();
        list.display();
    }
}
