public class sample {

    class Node {
        int data;
        Node right, left;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node root = null;

    public void addNode(int data) {
        Node current = root;
        if (root == null) {
            root = new Node(data);
            return;
        } else {
            while (true) {
                if (data > current.data) {
                    if (current.right == null) {
                        current.right = new Node(data);
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    if (current.left == null) {
                        current.left = new Node(data);
                        break;
                    } else {
                        current = current.left;
                    }
                }
            }
        }
    }

    public void display() {
        helperDisplay(root);
    }

    public void helperDisplay(Node current) {
        if (current != null) {
            helperDisplay(current.left);
            System.out.print(current.data + " ");
            helperDisplay(current.right);
        }
    }

    public void remove(int data) {
        removeHelper(data, root);
    }

    public Node removeHelper(int data, Node root) {

        if (data < root.data) {
            root.left = removeHelper(data, root.left);

        } else if (data > root.data) {
            root.right = removeHelper(data, root.right);
        } else {
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node MinValue = getMinValue(root.right);
                root.data = MinValue.data;
                root.right = removeHelper(root.data,root.right);
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

    public static void main(String[] args) {
        sample tree = new sample();

        tree.addNode(21);
        tree.addNode(32);
        tree.addNode(69);
        tree.addNode(210);
        tree.addNode(2);
        
        tree.display();
        System.out.println();
        tree.remove(21);
        tree.remove(69);
        tree.remove(2);

        tree.display();
    }
}
