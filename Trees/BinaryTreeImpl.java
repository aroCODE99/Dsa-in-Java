class Node {
    public int val;
    public Node left, right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeImpl {
    public static void main(String[] args) {
        Node root = null;
        root = BinaryTree.insertNode(5, root);
        root = BinaryTree.insertNode(3, root);
        root = BinaryTree.insertNode(7, root);
        root = BinaryTree.insertNode(1, root);
        root = BinaryTree.insertNode(4, root);

        System.out.println("5 is the root Node\n");
        System.out.println("in-order traversal:");
        BinaryTree.inOrderTraversal(root); // Expected output: 1 3 4 5 7
        System.out.println("\n\nPre-order traversal");
        BinaryTree.preOrderTraversal(root); // Expected output: 1 3 4 5 7
        System.out.println("\n\npost-order traversal");
        BinaryTree.postOrderTraversal(root); // Expected output: 1 3 4 5 7

        int val = 5;
        System.out.printf("\nsearching %d in tree result : %b", val, BinaryTree.search(val, root));
    }
}

class BinaryTree {
    public static Node insertNode(int val, Node tree) {
        if (tree == null) {
            return new Node(val);
        } else if (val >= tree.val) {
            tree.right = insertNode(val, tree.right);
        } else {
            tree.left = insertNode(val, tree.left);
        }
        return tree;
    }

    public static Node deleteNode(Node root, int val) {
        if (root == null) {
            return root;
        }

        if (val < rboot.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            // now this means that we found the
            // if the child has 0 childrens
            if (root.left == null && root.right == null) {
                return null;
            }

            // if has only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // if it has two childs you find the inOrderSuccesor (min of right and replace
            // the value with curr tree.val)
            root.val = minValue(root.right);

            // now delete that value
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public static int minValue(Node root) {
        int minVal = root.val;
        while (root.left != null) {
            root = root.left;
            minVal = root.val;
        }
        return minVal;
    }

    public static boolean search(int val, Node tree) {
        if (tree == null) {
            return false;
        }
        if (tree.val == val) {
            return true;
        }

        return val >= tree.val ? search(val, tree.right) : search(val, tree.left);
    }

    public static void inOrderTraversal(Node tree) {
        if (tree != null) {
            inOrderTraversal(tree.left);
            System.out.print(tree.val + "  ");
            inOrderTraversal(tree.right);
        }
    }

    public static void preOrderTraversal(Node tree) {
        if (tree != null) {
            System.out.print(tree.val + "  ");
            preOrderTraversal(tree.left);
            preOrderTraversal(tree.right);
        }
    }

    public static void postOrderTraversal(Node tree) {
        if (tree != null) {
            postOrderTraversal(tree.left);
            postOrderTraversal(tree.right);
            System.out.print(tree.val + "  ");
        }
    }

    private static int maxValue(Node root) {
        int maxVal = root.val;
        while (root.right != null) {
            root = root.right;
            maxVal = root.val;
        }
        return maxVal;
    }
}
