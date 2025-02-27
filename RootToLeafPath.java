package BinarySearchTree;

import java.util.ArrayList;

public class RootToLeafPath {
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

    // Method to print all root-to-leaf paths
    public static void printRootToLeafPaths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        // Add the current node's data to the path
        path.add(root.data);

        // If it's a leaf node, print the path
        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            // Recur for left and right subtrees
            printRootToLeafPaths(root.left, path);
            printRootToLeafPaths(root.right, path);
        }

        // Remove the current node from the path (backtracking)
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Insert values into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Print all root-to-leaf paths
        System.out.println("Root-to-leaf paths:");
        printRootToLeafPaths(root, new ArrayList<>());
    }
}
