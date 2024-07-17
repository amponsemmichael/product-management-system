package com.amponsem.product_management.util;
import com.amponsem.product_management.model.Product;

public class BinaryTree {
    private Node root;

    private static class Node {
        Product product;
        Node left;
        Node right;

        public Node(Product product) {
            this.product = product;
            left = null;
            right = null;
        }
    }

    public void add(Product product) {
        root = addRecursive(root, product);
    }

    private Node addRecursive(Node current, Product product) {
        if (current == null) {
            return new Node(product);
        }
        if (product.getName().compareTo(current.product.getName()) < 0) {
            current.left = addRecursive(current.left, product);
        } else if (product.getName().compareTo(current.product.getName()) > 0) {
            current.right = addRecursive(current.right, product);
        }
        return current;
    }

    public boolean containsNode(String name) {
        return containsNodeRecursive(root, name);
    }

    private boolean containsNodeRecursive(Node current, String name) {
        if (current == null) {
            return false;
        }
        if (name.equals(current.product.getName())) {
            return true;
        }
        return name.compareTo(current.product.getName()) < 0
                ? containsNodeRecursive(current.left, name)
                : containsNodeRecursive(current.right, name);
    }

    public void delete(String name) {
        root = deleteRecursive(root, name);
    }

    private Node deleteRecursive(Node current, String name) {
        if (current == null) {
            return null;
        }
        if (name.equals(current.product.getName())) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            String smallestValue = findSmallValue(current.right);
            current.product.setName(smallestValue);
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (name.compareTo(current.product.getName()) < 0) {
            current.left = deleteRecursive(current.left, name);
            return current;
        }
        current.right = deleteRecursive(current.right, name);
        return current;
    }

    private String findSmallValue(Node root) {
        return root.left == null ? root.product.getName() : findSmallValue(root.left);
    }
}

