package Java;
public class Stack {
    
    static class Node{
        int data;
        Node next;
            public Node(int data){
                this.data = data;
            }
    }

    public Node top;

    public void push(int data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
    }

    public void pop(){
        if(top == null){
            System.out.println("StackUnderflow");
            return;
        }
        top = top.next;
    }
    public void display(){
        Node temp = top;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(200);
        stack.push(200);
        stack.push(900);
        stack.push(7600);
        stack.pop();
        stack.display();
    }
}
