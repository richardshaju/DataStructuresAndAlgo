public class sample {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    public static void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
    }
    public static void deleteNode(int data){
        Node temp = head;
        Node prev = null;
        if(temp != null && temp.data == data){
            head = temp.next;
            return;
        }
        while(temp.data != data){
            prev = temp;
            temp = temp.next;
        }
        if(temp == tail){
            tail = prev;
            return;
        }
        prev.next = temp.next;
    }
    public static void display(){
        Node temp = head;
        if(head == null){
            System.out.println("Empty");
            return;
        }
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addNode(5);
        addNode(34);
        addNode(332);
        addNode(8);
        addNode(9);
        addNode(98);
        display();
    }
}
