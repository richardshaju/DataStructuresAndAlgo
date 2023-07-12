public class sample {

    class Node {
        int data;
        Node next;

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
        }
        tail = newNode;
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

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        sample link = new sample();
        link.addNode(5);
        link.addNode(6);
        link.addNode(610);
        link.addNode(99);
        link.addNode(56);
        link.addNode(0);
        link.addNode(990);
        link.sort();
        link.display();
    }
}
