package Labs.Lab9;

public class BST <T extends Comparable<T>>{

    Node<T> root;

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

    public boolean isEmpty() {

        return root == null;

    }

    public void traverseLNR(Node<T> node) {

        if (node == null)
            return;

        traverseLNR(node.left);
        System.out.print(node.data + " ");
        traverseLNR(node.right);

    }

    public void traverseNLR(Node<T> node) {

        if (node == null)
            return;

        System.out.print(node.data + " ");
        traverseNLR(node.left);
        traverseNLR(node.right);

    }

    public void traverseLRN(Node<T> node) {

        if (node == null)
            return;

        traverseLRN(node.left);
        traverseLRN(node.right);
        System.out.print(node.data + " ");

    }

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
        }

        return arr;

    }

    public void delNoChild(Node<T> parent, Node<T> temp) {

        if (parent.left.equals(temp))       // temp.data.compareTo(parent.data) < 0
            parent.left = null;
        else                                // temp.data.compareTo(parent.data) > 0
            parent.right = null;

    }

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
            }
        else{
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
        }
        else System.out.println("key not found");

    }


}
