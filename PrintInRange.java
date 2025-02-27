package BinarySearchTree;

public class PrintInRange {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert method (same as previous implementation)
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // Left subtree
            root.left = insert(root.left, val);
        } else {
            // Right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Method to print values in the given range [low, high]
    public static void printInRange(Node root, int low, int high) {
        if (root == null) {
            return;
        }

        // If root's data is greater than the low value, check the left subtree
        if (root.data > low) {
            printInRange(root.left, low, high);
        }

        // If root's data is within the range, print it
        if (root.data >= low && root.data <= high) {
            System.out.print(root.data + " ");
        }

        // If root's data is less than the high value, check the right subtree
        if (root.data < high) {
            printInRange(root.right, low, high);
        }
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Insert values into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Define the range
        int low = 2;
        int high = 5;

        System.out.print("Nodes within the range [" + low + ", " + high + "]: ");
        printInRange(root, low, high);
        System.out.println();
    }
}
