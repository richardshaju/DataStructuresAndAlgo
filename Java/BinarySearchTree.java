public class BinarySearchTree {
    class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
        }
    }

    public static Node root;

    public Node insert(int data) {
        return insertHelper(root, data);
    }

    public Node insertHelper(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = insertHelper(root.left, data);
        } else {
            root.right = insertHelper(root.right, data);
        }

        return root;

    }

    public void display() {
        inOrder(root);
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "  ");
            inOrder(root.right);
        } else {
            return;
        }
    }

  
    public void remove(int data) {
        removeHelper(root, data);
    }

    public Node removeHelper(Node current, int data) {
        if (current == null) {
            return null;
        }
        if (current.data < data) {
            current.right = removeHelper(current.right, data);
        } else if (current.data > data) {
            current.left = removeHelper(current.left, data);
        } else {
            
            if (current.right == null) {
                return current.left;
            } else if (current.left == null) {
                return current.right;
            }else{
                Node minVal = minValue(current.right);
                current.data = minVal.data;
                current.right = removeHelper(minVal, data);
            }
        }

        return current;
    }

    private Node minValue(Node current){
        if(current.left != null){
            return minValue(current.left);
        }else{
            return current;
        }
    }
    public void findMax(){
        findMaxHelper(root);
    }
    public void findMaxHelper(Node current) {
        if(current.right != null){
            findMaxHelper(current.right);
        }else{
            System.out.println("Max Value :" +  current.data);
        }

    }

    public void sum() {
    System.out.println(sumHelper(root));
       
    }

    public int sumHelper(Node current) {
        if (current != null) {
           return sumHelper(current.left) +  sumHelper(current.right) + current.data;
        } else {
            return 0;
        }
        

    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] values = { 1, 2, 3,4,5,6,5050};
        for (int i = 0; i < values.length; i++) {
            root = tree.insert(values[i]);
        }
        tree.display();
        System.out.println();
        tree.findMax();
        tree.remove(5050);
        tree.display();
        tree.findMax();
        tree.sum();

    }
}
