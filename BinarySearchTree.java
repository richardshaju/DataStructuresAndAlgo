public class BinarySearchTree {
     class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void insert(int data) {
        Node currentNode = root;
        if (currentNode == null) {
            root = new Node(data);
            return;
        }
        while (true) {
            if (data < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(data);
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(data);
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public boolean contains(int data) {
        Node currentNode = root;
        while (currentNode != null) {
            if (data < currentNode.data) {
                currentNode = currentNode.left;
            } else if (data > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }
        return false;

    }

  
    public void delete(int val) {
        deleteHelper(root, val);
    }

    public Node deleteHelper(Node root, int val) {
        if (val < root.data) {
            root.left = deleteHelper(root.left, val);
        } else if (val > root.data) {
            root.right = deleteHelper(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;

            } else {
               Node MinValue = getMinValue(root.right);
               root.data = MinValue.data;
               root.right = deleteHelper(root.right,root.data);

            }
        }
        return root;
    }

    public Node getMinValue(Node currentNode) {
        if (currentNode.left == null) {
            return currentNode;
        } else {
            return getMinValue(currentNode.left);
        }
    }

    public void inOrder() {
        inOrderHelper(root);
    }

    public void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + "  ");
            inOrderHelper(node.right);
        }
    }

    public void preOrder() {
        preOrderHelper(root);

    }

    public void preOrderHelper(Node node) {
        if (node != null) {
            System.out.print(node.data + "  ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    public void postOrder() {
        postOrderHelper(root);
    }

    public void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + "  ");
        }
    }

    public int findClosest(int target) {
        Node currentNode = root;
        int closest = currentNode.data;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.data)) {
                closest = currentNode.data;
            }
            if (target < currentNode.data) {
                currentNode = currentNode.left;
            } else if (target > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();

        int[] values = { 10, 46, 3, 4, 90,76,355,67,21 };
        for (int i = 0; i < values.length; i++) {
            BST.insert(values[i]);
        }
        BST.delete(10);
        BST.delete(90);
        BST.delete(3);

        BST.inOrder();
        System.out.println();
        BST.preOrder();
        System.out.println();
        BST.postOrder();
        System.out.println();

        System.out.println(BST.findClosest(6));
    }
}
