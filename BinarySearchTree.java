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
        if (data == root.data) {
            if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                Node minValue = getMinValue(root.right);
                root.data = minValue.data;
                root.right = removeHelper(minValue, data);
            }
        } else {

            removeHelper(root, data);
        }
    }

    public Node removeHelper(Node root, int value) {
        if (value < root.data) {
            root.left = removeHelper(root.left, value);
        } else if (value > root.data) {
            root.right = removeHelper(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                return null;

            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node minValue = getMinValue(root.right);
                root.data = minValue.data;
                root.right = removeHelper(minValue, value);
            }
        }
        return root;
    }

    public Node getMinValue(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return getMinValue(root.left);
        }

    }

    public void findMax() {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("Max Value = " + current.data);
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
        int[] values = { 1, 2, 3};
        for (int i = 0; i < values.length; i++) {
            root = tree.insert(values[i]);
        }
        tree.display();
        System.out.println();
        tree.findMax();

        tree.display();
        tree.findMax();
        tree.sum();

    }
}
