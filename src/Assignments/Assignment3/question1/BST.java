package question1;

public class BST<T extends Comparable<T>>{

    private Node<T> root;

    /**
     * inserts a node with the given key in the question1.BST
     * @param key is the data to be inserted
     */
    public void insert(T key) {

        Node<T> newNode = new Node<T>(key);

        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> temp = root;
        Node<T> prev = root;

        while(temp != null){

            prev = temp;

            if (temp.data.compareTo(key) > 0) {
                temp = temp.left;
            } else if (temp.data.compareTo(key) < 0) {
                temp = temp.right;
            } else throw new RuntimeException("similar data found!\neach data must be unique!");

        }

        if (prev.data.compareTo(key) > 0) {
            prev.left = newNode;
        } else if (prev.data.compareTo(key) < 0) {
            prev.right = newNode;
        }

    }

    /**
     * searches for a specific key in the question1.BST
     * @param key is the data to be searched for
     * @return the node at which the data is situated
     */
    public Node<T> find(T key) {

        Node<T> temp= root;
        while (temp!=null && key.compareTo(temp.data) != 0){

            if (temp.data.compareTo(key) > 0)
                temp = temp.left;
            else if (temp.data.compareTo(key) < 0)
                temp = temp.right;

        }

        if(temp !=null && key.compareTo(temp.data)==0)
            return temp;

        return null;

    }

    /**
     * checks if question1.BST is empty
     * @return true if empty, and false otherwise
     */
    public boolean isEmpty() {

        return root == null;

    }

    /**
     * traverse the question1.BST level-by-level (BFS)
     * @param n is node from which you have to start the search
     */
    public void traverse(Node<T> n) {

        if (isEmpty())
            throw new RuntimeException("tree is empty!");

        Queue<Node<T>> q = new Queue<>();
        q.enqueue(n);
        while (!q.isEmpty()) {
            Node<T> temp = q.dequeue();
            System.out.print(temp.data + " ");
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
    public void traverseLNR(Node<T> node) {

        if (node == null)
            return;

        traverseLNR(node.left);
        System.out.print(node.data + " ");
        traverseLNR(node.right);

    }

    /**
     * traverses the question1.BST in NLR
     * @param node is the reference node
     */
    public void traverseNLR(Node<T> node) {

        if (node == null)
            return;

        System.out.print(node.data + " ");
        traverseNLR(node.left);
        traverseNLR(node.right);

    }

    /**
     * traverses the question1.BST in LRN
     * @param node is the reference node
     */
    public void traverseLRN(Node<T> node) {

        if (node == null)
            return;

        traverseLRN(node.left);
        traverseLRN(node.right);
        System.out.print(node.data + " ");

    }

    /**
     * searches for a specific node
     * @param key is the data to be searched for
     * @return an array containing the node to be searched for and its parent
     */
    public Node[] findArr(T key) {

        Node[] arr = new Node[2];

        Node<T> temp= root;
        Node<T> parent = null;
        while (temp!=null && key.compareTo(temp.data) != 0){

            parent = temp;

            if (temp.data.compareTo(key) > 0)
                temp = temp.left;
            else if (temp.data.compareTo(key) < 0)
                temp = temp.right;

        }

        if(temp !=null && key.compareTo(temp.data)==0) {
            arr[0] = parent;
            arr[1] = temp;
            return arr;
        }

        return null;

    }

    /**
     * in order to delete a node with a no children
     * @param parent is the parent of the node to be removed
     * @param temp is the node to be removed
     */
    public void delNoChild(Node<T> parent, Node<T> temp) {

        if (parent.left.equals(temp))       // temp.data.compareTo(parent.data) < 0
            parent.left = null;
        else                                // temp.data.compareTo(parent.data) > 0
            parent.right = null;

    }

    /**
     * in order to delete a node with a single child
     * @param parent is the parent of the node to be removed
     * @param temp is the node to be removed
     */
    public void delOneChild(Node<T> parent, Node<T> temp) {

        if (parent.left.equals(temp)) {     // temp.data.compareTo(parent.data) < 0

            if (temp.left != null)
                parent.left = temp.left;
            else parent.left = temp.right;

        } else {                            // temp.data.compareTo(parent.data) > 0

            if (temp.left != null)
                parent.right = temp.left;
            else parent.right = temp.right;

        }

    }

    /**
     * in order to delete a node with two children
     * @param temp is the node to be removed
     */
    public void delTwoChild(Node<T> temp) {

        Node<T> prev = temp;
        Node<T> curr = temp.right;
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }

        temp.data = curr.data;

        if (curr.right == null)
            delNoChild(prev, curr);
        else delOneChild(prev, curr);

    }

    /**
     * deletes a node from the tree
     * @param key is the data at the node to be removed
     */
    public void delete(T key) {

        Node[] ref = findArr(key);

        Node<T> parent = ref[0];
        Node<T> temp = ref[1];

        if(temp!=null&&key.compareTo(temp.data)==0){

            if(temp.left==null && temp.right==null){ // no child case
                delNoChild(parent,temp);
            } // one child case
            else if((temp.left!=null &&temp.right==null)||(temp.left==null && temp.right!=null)){
                delOneChild(parent,temp);
            } else {
                delTwoChild(temp);
            }
        }
        else System.out.println("key not found");

    }

    /**
     * prints all the data within a certain range
     * @param node is the reference node
     * @param k1 is the lower limit of the range
     * @param k2 is the upper limit of the range
     */
    public void printRange(Node<T> node, T k1, T k2) {

        if (node == null)
            return;

        if (node.data.compareTo(k1) < 0) {
            printRange(node.right, k1, k2);
            return;
        }

        if (node.data.compareTo(k2) > 0) {
            printRange(node.left, k1, k2);
            return;
        }

        printRange(node.left, k1, k2);
        System.out.println(node.data);
        printRange(node.right, k1, k2);

    }

    public Node<T> getRoot() {
        return root;
    }
}
