package BinarySearchTree;

public class SearchInBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert method (same as your previous implementation)
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

    // Search method
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false; // Key not found
        }

        if (root.data == key) {
            return true; // Key found
        }

        if (key < root.data) {
            // Search in left subtree
            return search(root.left, key);
        } else {
            // Search in right subtree
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Insert values into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Search for a specific key
        int key = 4;
        if (search(root, key)) {
            System.out.println("Key " + key + " found in the BST.");
        } else {
            System.out.println("Key " + key + " not found in the BST.");
        }
    }
}
