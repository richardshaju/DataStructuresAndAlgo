public class DoublyLinkedList {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public void deleteNode(int data) {
        Node temp = head;
        Node prevNode = null;
        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != data) {
            prevNode = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value Not find");
            return;
        }
        if (temp == tail) {
            tail = prevNode;
            tail.next = null;
            return;
        }
        prevNode.next = temp.next;
        temp.next.prev = prevNode;
    }

    public static void main(String[] args) {
        DoublyLinkedList DList = new DoublyLinkedList();
        DList.addNode(5);
        DList.addNode(50);
        DList.addNode(500);
        DList.addNode(5000);
        DList.addNode(50000);
        DList.deleteNode(50 );
        DList.display();
    }
}
