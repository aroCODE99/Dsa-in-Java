import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeImpl {
    public static void main(String[] args) {
        TreeNode root = null;
        root = BinaryTree.insertNode(3, root);
        root = BinaryTree.insertNode(5, root);
        root = BinaryTree.insertNode(7, root);
        root = BinaryTree.insertNode(1, root);
        root = BinaryTree.insertNode(4, root);

        // System.out.println("3 is the root TreeNode");
        // System.out.println("in-order traversal:");
        // BinaryTree.inOrderTraversal(root); // Expected output: 1 3 4 5 7
        // System.out.println("\n\nPre-order traversal");
        // BinaryTree.preOrderTraversal(root); // Expected output: 1 3 4 5 7
        // System.out.println("\n\npost-order traversal");
        // BinaryTree.postOrderTraversal(root); // Expected output: 1 3 4 5 7

        // int val = 7;
        // System.out.printf("\nsearching %d in tree result : %b", val,
        // BinaryTree.search(val, root));

        // System.out.println("\ntotal no. of Nodes: " + BinaryTree.countNodes(root));
        // System.out.println("\ntotal no. of Nodes(Simplified version): " +
        // BinaryTree.countNodesII(root));

        // System.out.println("\nheight of current Tree: " +
        // BinaryTree.findTheHeightII(root));

        // if (BinaryTree.isBalanced(root)) {
        // System.out.println("The tree is balanced.");
        // } else {
        // System.out.println("The tree is not balanced.");
        // }

        // System.out.println("\nLevelOrder Traversal (BFS)");
        // System.out.println(BinaryTree.levelOrderII(root));

        // System.out.println("\nDepth of the Tree with Breadth-first-approach");
        // System.out.println(BinaryTree.depthOfTreeWithBFS(root));

        // System.out.println("\n Average At EachLevel: " +
        // BinaryTree.averageOfLevels(root));

        // int x = 3;
        // System.out.printf("\n Successor of %d is %d ", x,
        // BinaryTree.findSuccesor(root, x));

        // List<List<Integer>> zigZagTraversal = BinaryTree.zigzagLevelOrder(root);
        // System.out.println(zigZagTraversal);
        //
        // int x = 1, y = 2;
        // System.out.println(BinaryTree.isCousins(x, y, root));

        // int[] nums = { -10, -5, 0, 5, 9 };
        // BinaryTree.preOrderTraversal(BinaryTree.sortedArrayToBST(nums));

        BinaryTree.flatten(root);
    }

}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class BinaryTree {
    static int maxDiameter = 0;

    public static TreeNode insertNode(int val, TreeNode tree) {
        if (tree == null) {
            return new TreeNode(val);
        } else if (val >= tree.val) {
            tree.right = insertNode(val, tree.right);
        } else {
            tree.left = insertNode(val, tree.left);
        }
        return tree;
    }

    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        if (val < root.val) {
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

    public static int minValue(TreeNode root) {
        int minVal = root.val;
        while (root.left != null) {
            root = root.left;
            minVal = root.val;
        }
        return minVal;
    }

    private static int maxValue(TreeNode root) {
        int maxVal = root.val;
        while (root.right != null) {
            root = root.right;
            maxVal = root.val;
        }
        return maxVal;
    }

    public static boolean search(int val, TreeNode tree) {
        if (tree == null) {
            return false;
        }
        if (tree.val == val) {
            return true;
        }

        return val >= tree.val ? search(val, tree.right) : search(val, tree.left);
    }

    public static void levelOrder(TreeNode root) {
        // if root is null return back
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            System.out.print(currNode.val + " ");

            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
            }

        }

    }

    public static List<List<Integer>> levelOrderII(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int n = queue.size();
            // we will add the curr level node's to this list and the
            // then we will add this curr List to res List

            List<Integer> currList = new ArrayList<>();
            while (n > 0) {
                TreeNode currNode = queue.poll();
                currList.add(currNode.val);

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

                n -= 1;
            }

            res.add(currList);
        }

        return res;
    }

    public static void inOrderTraversal(TreeNode tree) {
        // going in all left
        if (tree != null) {
            inOrderTraversal(tree.left);
            System.out.println(tree.val + "  ");
            inOrderTraversal(tree.right);
        }
    }

    public static void preOrderTraversal(TreeNode tree) {
        if (tree != null) {
            System.out.print(tree.val + "  ");
            preOrderTraversal(tree.left);
            preOrderTraversal(tree.right);
        }
    }

    public static void postOrderTraversal(TreeNode tree) {
        if (tree != null) {
            postOrderTraversal(tree.left);
            postOrderTraversal(tree.right);
            System.out.print(tree.val + "  ");
        }
    }

    public static int countNodes(TreeNode tree) {
        // initiating the node count var
        int totalNodes = 0;
        if (tree != null) {
            // if currNode is not null that means that means nodeCount increment
            totalNodes += 1;
            totalNodes += countNodes(tree.left);
            totalNodes += countNodes(tree.right);
        }
        return totalNodes;
    }

    public static int countNodesII(TreeNode tree) {
        // this is more simplified version of countNodes
        if (tree == null) {
            return 0;
        }
        return 1 + countNodesII(tree.left) + countNodesII(tree.right);
    }

    // code for finding the depth/height of the tree
    public static int depthOfTreeWithBFS(TreeNode root) {
        int count = 0; // we are using counter to keep the track of height
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n > 0) {
                TreeNode currNode = queue.poll();

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                n -= 1;
            }

            count += 1;
        }

        return count;
    }

    public static int findTheHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findTheHeight(root.left);
        int rightHeight = findTheHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalanced(TreeNode tree) {
        return Height(tree) != -1;
    }

    private static int Height(TreeNode tree) {
        // means we at leaf TreeNode
        if (tree == null) {
            return 0;
        }

        int leftHeight = Height(tree.left);
        int rightHeight = Height(tree.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // first we swapp the left to right and right to left
        // it doesn't matter if they are null
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // then we go left and right
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        System.out.println(res);
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            // this is going to be the last remaining Node of the current level
            TreeNode lastNode = null;

            while (n > 0) {
                TreeNode currNode = queue.poll();
                lastNode = currNode;

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

                n--;
            }

            res.add(lastNode.val);
        }

        return res;
    }

    public static List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        preOrderRight(root, 1, res);

        return res;
    }

    private static void preOrderRight(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() < level) {
            // what does this statement says
            // this means that left node of the level is missing
            res.add(root.val);
        }

        // so we goo first to the right and if we the right is null we go to the left
        preOrderRight(root.right, level + 1, res);
        preOrderRight(root.left, level + 1, res);
    }

    public static List<Integer> sumAtEachLevel(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int sumAtEachLevel = 0;

            while (n > 0) {
                TreeNode currNode = queue.poll();
                sumAtEachLevel += currNode.val;

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

                n -= 1;
            }

            res.add(sumAtEachLevel);
        }
        return res;
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int totalNodes = n;
            Double sum = 0.0;

            while (n > 0) {
                TreeNode currNode = queue.poll();
                sum += currNode.val;

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

                n -= 1;
            }
            Double avg = sum / totalNodes;
            res.add(avg);

        }
        return res;
    }

    public static TreeNode findSuccesor(TreeNode root, int x) {
        // what does succesor even mean ?
        // if root is null return back
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean isFound = false;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            System.out.print(currNode.val + " ");

            if (isFound) {
                return queue.peek();
            }

            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
            }

            if (currNode.val == x) {
                // currNode should be not the output but rather the next in BFS order should be
                // the one
            }

        }

        return null;

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // Use a deque to perform level-order traversal
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean leftToRight = true; // Flag to indicate direction

        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> level = new ArrayList<>();

            while (n > 0) {
                if (leftToRight) {
                    // if it is leftToRight we will just make deque act like a normal queue
                    TreeNode currNode = deque.pollFirst();
                    level.add(currNode.val);

                    if (currNode.left != null) {
                        deque.offerLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        deque.offerLast(currNode.right);
                    }
                } else {
                    // now here we make a use of deque and make it act like ulta queue
                    TreeNode currNode = deque.pollLast();
                    level.add(currNode.val);

                    if (currNode.right != null) {
                        deque.offerFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        deque.offerFirst(currNode.left);
                    }
                }
                n--;
            }
            leftToRight = !leftToRight;
            res.add(level);
        }

        return res;
    }

    public static boolean isCousins(int x, int y, TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean xFind = false;
            boolean yFind = false;

            int n = queue.size();

            while (n > 0) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null && currNode.right != null) {
                    // checking if they belong to the same parent
                    if ((currNode.left.val == x && currNode.right.val == y) ||
                            (currNode.left.val == y && currNode.right.val == x)) {
                        return false; // Same parent
                    }
                }

                // now we check that if node is present in cousin's or not
                if (currNode.left != null) {
                    queue.add(currNode.left);
                    if (currNode.left.val == x) {
                        xFind = true;
                    } else if (currNode.left.val == y) {
                        yFind = true;
                    }
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                    if (currNode.right.val == x) {
                        xFind = true;
                    } else if (currNode.right.val == y) {
                        yFind = true;
                    }
                }

                n -= 1;
            }

            if (xFind && yFind) {
                return true;
            }
            if (xFind || yFind) {
                return false;
            }
        }

        return false;
    }

    public static boolean isCousinsII(int x, int y, TreeNode root) {
        // Map val way
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Map<Integer, TreeNode> map = new HashMap<>();
            int n = queue.size();
            while (n > 0) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    map.put(currNode.left.val, currNode);
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    map.put(currNode.right.val, currNode);
                    queue.add(currNode.right);
                }
                n -= 1;
            }

            if (map.containsKey(x) && map.containsKey(y) && map.get(x) != map.get(y)) {
                return true;
            }

        }

        return false;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirrored(root.left, root.right);
    }

    private static boolean isMirrored(TreeNode leftNode, TreeNode rightNode) {
        // if both are null, it mean's that the tree is symmetric
        if (leftNode == null && rightNode == null) {
            return true;
        }

        // if anyone is null return false
        if (leftNode == null || rightNode == null) {
            return false;
        }

        // now we go deep only if the right and left are equal
        return (leftNode.val == rightNode.val) &&
                isMirrored(leftNode.left, rightNode.right) && isMirrored(leftNode.right, rightNode.left);
    }

    // now DFS terriotory has been started
    public static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);

        // we cal the diameter
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight + 1);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildTree(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = start + (end - start) / 2;

        // now create the new root node
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);

        return root;
    }

    // this is going to be the helper to flatten method
    private static TreeNode prev = null;

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return root;
    }
}
