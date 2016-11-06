/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Brian Martinez
 */
public class LinkedListTree<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    
    public int size()
    {
        return size(root);
    }
    
    private int size(Node x)
    {
        if (x == null) return 0;
        else return x.size;
    }

    public Value get(Key key)
    {
        return get(root, key);
    }
    
    private Value get(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }
    
    public void put(Key key, Value val)
    {
        root = put(root, key, val);
    }
    
    private Node put(Node x, Key key, Value val)
    {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = size(x.left) + size(x.right) + 1;
//        if (x.size > 1)
//        {
//            // re-balance tree
//        }
        return x;
    }
    
    public void delete(Key key)
    {
        root = delete(root, key);
    }
    
    private Node delete(Node x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else
        {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    private Node deleteMin(Node x)
    {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    private Node min(Node x)
    {
        if (x.left == null) return x;
        return min(x.left);
    }
    
    public void print(Node x)
    {
        if (x == null) return;
        print(x.left);
        System.out.println(x.key);
        print(x.right);
    }
}
