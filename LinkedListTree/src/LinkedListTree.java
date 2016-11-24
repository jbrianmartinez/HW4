/*
 *  Java Program to Implement Self Balancing Binary Search Tree
 */
 
 import java.util.Scanner;
 
 /* Class Node */
 
 /* Class LinkedListTree */
 public class LinkedListTree<Key extends Comparable<Key>, Value> {
     private Node root;     
     private int balanceCnt = 0;
 
     private class Node {  
        Node left, right;
        Key key;
        Value value;
        int height;

        /* Constructor */
        public Node() {
            left = null;
            right = null;
            key = null;
            value = null;
            height = 0;
        }

        /* Constructor */
        public Node(Key key, Value val, int height) {
            this.key = key;
            this.value = val;
            this.height = height;
        }     
    }
 
     /* Constructor */
     public LinkedListTree() {
         root = null;
     }
 
     /* Function to check if tree is empty */
     public boolean isEmpty() {
         return root == null;
     }
 
     /* Make the tree logically empty */
     public void clear() {
         root = null;
     }

     /* Function to insert data */
     public void insert(Key key, Value val) {
         root = insert(key, val, root);
     }

     /* Function to get height of node */
     private int height(Node t ) {
         return t == null ? -1 : t.height;
     }

     /* Function to max of left/right node */
     private int max(int lhs, int rhs) {
         return lhs > rhs ? lhs : rhs;
     }

     /* Function to insert data recursively */
     private Node insert(Key key, Value val, Node t) {
         if (t == null)  t = new Node(key, val, 0);
         else {
            int cmp = key.compareTo(t.key);
            if (cmp < 0) {
                t.left = insert(key, val, t.left );
                if (height(t.left) - height(t.right) == 2) {
                    if (key.compareTo(t.left.key) < 0)
                        t = rotateWithLeftChild( t );
                    else
                        t = doubleWithLeftChild( t );
                    balanceCnt++;
                }
            } else if (cmp > 0) {
                t.right = insert(key, val, t.right);
                if (height(t.right) - height(t.left) == 2) {
                    if (key.compareTo(t.right.key) > 0)
                        t = rotateWithRightChild( t );
                    else
                        t = doubleWithRightChild( t );
                    balanceCnt++;
                }
            }
         }

         t.height = max(height(t.left), height(t.right)) + 1;
         return t;
     }
     
     public int GetBalanceCount() {
         return balanceCnt;
     }

     /* Rotate binary tree node with left child */     
     private Node rotateWithLeftChild(Node k2) {
         Node k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }
 
     /* Rotate binary tree node with right child */
     private Node rotateWithRightChild(Node k1) {
         Node k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }

     /**
      * Double rotate binary tree node: first left child
      * with its right child; then node k3 with new left child */
     private Node doubleWithLeftChild(Node k3) {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }

     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */      
     private Node doubleWithRightChild(Node k1) {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }  
  
     /* Functions to count number of nodes */
     public int countNodes() {
         return countNodes(root);
     }

     private int countNodes(Node r) {
         if (r == null)  return 0;
         else {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }

     /* Functions to search for an element */
     public boolean search(Key key) {
         return search(root, key);
     }

     private boolean search(Node r, Key key) {
         boolean found = false;
         while ((r != null) && !found) {
             Key rval = r.key;
             if (key.compareTo(rval) < 0)
                r = r.left;
             else if (key.compareTo(rval) > 0)
                r = r.right;
             else {
                found = true;
                break;
            }
            found = search(r, key);
        }
        return found;
     }

     /* Function for inorder traversal */
     public void inorder() {
         inorder(root);
     }

     private void inorder(Node r) {
         if (r != null) {
             inorder(r.left);
             System.out.print(r.key +" ");
             inorder(r.right);
         }
     }

     /* Function for preorder traversal */
     public void preorder() {
         preorder(root);
     }

     private void preorder(Node r) {
         if (r != null) {
             System.out.print(r.key +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }

     /* Function for postorder traversal */
     public void postorder() {
         postorder(root);
     }

     private void postorder(Node r) {
         if (r != null) {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.key +" ");
         }
     }     
 }
 
