package Assignments.Assignment3.question2;

import question1.Queue;

import java.io.*;
import java.util.Collections;

public class DictionaryBST{

    private DictionaryNode root;
    private final boolean balancing;

    /**
     * constructor
     * @param pathname is the path of the file to read
     * @param balancing if true then tree is balanced using the method described in the Word file, otherwise it is randomly shuffled
     * @throws IOException if file not found
     */
    public DictionaryBST(String pathname, boolean balancing) throws IOException {

        this.balancing = balancing;
        getTreeFromFile(pathname);

    }

    /**
     * constructs a tree from the data read from a file
     * @param pathname is the path of the file to be read
     */
    private void getTreeFromFile(String pathname) throws IOException {

        // if true then tree is balanced using the method described in the Word file, otherwise it is randomly shuffled

        if (!balancing) {

            java.util.ArrayList<DictionaryNode> dList = new java.util.ArrayList<>();
            FileInputStream fStream = new FileInputStream(pathname);
            DataInputStream in = new DataInputStream(fStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] word = strLine.split(",", 2);
                DictionaryNode DN = new DictionaryNode(word[0], word[1]);
                dList.add(DN);
            }
            in.close();

            System.out.println("dList size for random shuffling: " + dList.size());

            // randomly shuffling
            Collections.shuffle(dList);
            for (DictionaryNode DN: dList)
                insert(DN);

        } else {

            // my array list (dynamic)
            ArrayList<DictionaryNode> list = new ArrayList<>();
            FileInputStream fStream = new FileInputStream(pathname);
            DataInputStream in = new DataInputStream(fStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] word = strLine.split(",", 2);
                DictionaryNode DN = new DictionaryNode(word[0], word[1]);
                list.insert(DN);
            }
            in.close();

            System.out.println("total list size for balancing: " + list.size() + " (occupied cells: " + list.length() + ")");

            root = arrayToBT(list, 0, list.length() - 1);

        }

    }

    /**
     * converts a sorted array into a question1.BST by recursively dividing the arr into two and placing the middle element on the right and left of that node as the right and left child of that particular node respectively
     * @param arr is the array to be converted into a BT (if sorted, it gives a BST)
     * @param start is the start index
     * @param end is the last index
     * @return the root of the BT that is constructed
     */
    private DictionaryNode arrayToBT(ArrayList<DictionaryNode> arr, int start, int end) {

        // return if start is greater than null (which means it is the leaf node)
        if (start > end)
            return null;

        // get the middle node
        int mid = (start + end) / 2;
        DictionaryNode node = arr.get(mid);

        // construct the right child of the middle node
        node.right = arrayToBT(arr, mid + 1, end);

        // construct the left subtree of the middle node
        node.left = arrayToBT(arr, start, mid - 1);

        // return the root node
        return node;
    }

    /**
     * inserts a Dictionary question1.Node in the question1.BST
     * @param word is the word to be inserted
     * @param meaning is its meaning
     */
    public void insert(String word, String meaning) {

        DictionaryNode newNode = new DictionaryNode(word, meaning);
        insert(newNode);

    }

    /**
     * inserts a Dictionary question1.Node in the question1.BST
     * @param newNode is that node
     */
    public void insert(DictionaryNode newNode) {

        if (root == null) {
            root = newNode;
            return;
        }

        String word = newNode.word;

        DictionaryNode temp = root;
        DictionaryNode prev = root;

        while(temp != null){

            prev = temp;

            if (temp.word.compareTo(word) > 0)
                temp = temp.left;
            else if (temp.word.compareTo(word) < 0)
                temp = temp.right;
            else throw new RuntimeException("similar word found!\neach word must be unique!");


        }

        if (prev.word.compareTo(word) > 0)
            prev.left = newNode;
        else if (prev.word.compareTo(word) < 0)
            prev.right = newNode;

    }

    /**
     * searches for a word in the dictionary
     * @param word is the word to be searched for
     * @return the node of the word
     */
    public DictionaryNode find(String word) {

        DictionaryNode temp= root;
        while (temp!=null && word.compareTo(temp.word) != 0){

            if (temp.word.compareTo(word) > 0)
                temp = temp.left;
            else if (temp.word.compareTo(word) < 0)
                temp = temp.right;

        }

        if(temp !=null && word.compareTo(temp.word)==0)
            return temp;

        // word not found
        return null;

    }

    /**
     * checks if tree is empty or not
     * @return true if it is (and false otherwise)
     */
    public boolean isEmpty() {

        return root == null;

    }

    /**
     * traverse the question1.BST level-by-level (BFS)
     * @param n is node from which you have to start the search
     */
    public void traverse(DictionaryNode n) {

        if (isEmpty())
            throw new RuntimeException("tree is empty!");

        Queue<DictionaryNode> q = new Queue<>();
        q.enqueue(n);
        while (!q.isEmpty()) {
            DictionaryNode temp = q.dequeue();
            System.out.print(temp.word + " ");
            if (temp.left != null)
                q.enqueue(temp.left);
            if (temp.right != null)
                q.enqueue(temp.right);

        }

        System.out.println();
    }

    /**
     * traverses the question1.BST in LNR
     * @param node is the reference node
     */
    public void traverseLNR(DictionaryNode node) {

        if (node == null)
            return;

        traverseLNR(node.left);
        System.out.print(node.word + " ");
        traverseLNR(node.right);

    }

    /**
     * traverses the question1.BST in NLR
     * @param node is the reference node
     */
    public void traverseNLR(DictionaryNode node) {

        if (node == null)
            return;

        System.out.print(node.word + " ");
        traverseNLR(node.left);
        traverseNLR(node.right);

    }

    /**
     * traverses the question1.BST in LRN
     * @param node is the reference node
     */
    public void traverseLRN(DictionaryNode node) {

        if (node == null)
            return;

        traverseLRN(node.left);
        traverseLRN(node.right);
        System.out.print(node.word + " ");

    }

    /**
     * searches for a specific node
     * @param word is the data to be searched for
     * @return an array containing the node to be searched for and its parent
     */
    public DictionaryNode[] findArr(String word) {

        DictionaryNode[] arr = new DictionaryNode[2];

        DictionaryNode temp= root;
        DictionaryNode parent = null;
        while (temp!=null && word.compareTo(temp.word) != 0){

            parent = temp;

            if (temp.word.compareTo(word) > 0)
                temp = temp.left;
            else if (temp.word.compareTo(word) < 0)
                temp = temp.right;

        }

        if(temp !=null && word.compareTo(temp.word)==0) {
            arr[0] = parent;
            arr[1] = temp;
        }

        return arr;

    }

    /**
     * in order to delete a node with a no children
     * @param parent is the parent of the node to be removed
     * @param temp is the node to be removed
     */
    public void delNoChild(DictionaryNode parent, DictionaryNode temp) {

        if (parent.left != null && parent.left.equals(temp))       // temp.word.compareTo(parent.word) < 0
            parent.left = null;
        else                                // temp.word.compareTo(parent.word) > 0
            parent.right = null;

    }

    /**
     * in order to delete a node with a single child
     * @param parent is the parent of the node to be removed
     * @param temp is the node to be removed
     */
    public void delOneChild(DictionaryNode parent, DictionaryNode temp) {

        if (parent.left != null && parent.left.equals(temp)) {     // temp.word.compareTo(parent.word) < 0

            if (temp.left != null)
                parent.left = temp.left;
            else parent.left = temp.right;

        } else {                            // temp.word.compareTo(parent.word) > 0

            if (temp.left != null)
                parent.right = temp.left;
            else parent.right = temp.right;

        }

    }

    /**
     * in order to delete a node with two children
     * @param temp is the node to be removed
     */
    public void delTwoChild(DictionaryNode temp) {

        DictionaryNode prev = temp;
        DictionaryNode curr = temp.right;
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }

        temp.word = curr.word;

        if (curr.right == null)
            delNoChild(prev, curr);
        else delOneChild(prev, curr);

    }

    /**
     * deletes a node from the tree
     * @param word is the data at the node to be removed
     */
    public void delete(String word) {


        DictionaryNode[] ref = findArr(word);

        DictionaryNode parent = ref[0];
        DictionaryNode temp = ref[1];

        if(temp!=null&&word.compareTo(temp.word)==0){

            if(temp.left==null && temp.right==null){ // no child case
                delNoChild(parent,temp);
            } // one child case
            else if((temp.left!=null &&temp.right==null)||(temp.left==null && temp.right!=null)){
                delOneChild(parent,temp);
            } else {
                delTwoChild(temp);
            }
        }

        else System.out.println("word not found!");

    }

    /**
     * prints all the data within a certain range
     * @param node is the reference node
     * @param k1 is the lower limit of the range
     * @param k2 is the upper limit of the range
     */
    public void printRange(DictionaryNode node, String k1, String k2) {

        if (node == null)
            return;

        if (node.word.compareTo(k1) < 0) {
            printRange(node.right, k1, k2);
            return;
        }

        if (node.word.compareTo(k2) > 0) {
            printRange(node.left, k1, k2);
            return;
        }

        printRange(node.left, k1, k2);
        System.out.println(node.word);
        printRange(node.right, k1, k2);

    }

    public DictionaryNode getRoot() {
        return root;
    }
}
