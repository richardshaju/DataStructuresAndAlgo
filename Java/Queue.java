public class Queue {

    class Node{
        int data;
        Node next;
            Node(int data){
                this.data = data;
            }
    }
    public Node rear = null;
    public Node front = null;

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }



    public void display(){
        Node temp = front;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(56);
        queue.enqueue(6);
        queue.enqueue(5);
        queue.display();
    }
}