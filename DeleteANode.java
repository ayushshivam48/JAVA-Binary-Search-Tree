package BinarySearchTree;

public class DeleteANode {
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

    // In-order traversal method (to display the BST)
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Method to find the minimum value node in a subtree
    public static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete method
    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.data) {
            // Go to the left subtree
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            // Go to the right subtree
            root.right = delete(root.right, val);
        } else {
            // Node to be deleted found

            // Case 1: Node with no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node with only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node with two children
            // Find the in-order successor (smallest value in the right subtree)
            Node minNode = findMin(root.right);
            root.data = minNode.data; // Replace the data
            root.right = delete(root.right, minNode.data); // Delete the in-order successor
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Insert values into the BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.print("In-order traversal before deletion: ");
        inorder(root);
        System.out.println();

        // Delete a specific value from the BST
        int valToDelete = 3;
        root = delete(root, valToDelete);

        System.out.print("In-order traversal after deletion: ");
        inorder(root);
        System.out.println();
    }
}
