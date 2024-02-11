package Labs.Lab9;

public class Driver {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(8);
        bst.insert(6);

        System.out.println(bst.find(4));
        System.out.println(bst.find(2));

        bst.traverse(bst.root);

        bst.traverseLNR(bst.root);
        System.out.println();

        bst.traverseNLR(bst.root);
        System.out.println();

        bst.traverseLRN(bst.root);
        System.out.println();

        // two-child case:

        bst.delete(5);
        bst.traverse(bst.root);

        // no-child case:

        bst.delete(1);
        bst.traverse(bst.root);

        // one-child case:

        bst.delete(7);
        bst.traverse(bst.root);

        // BST Array:

        BSTArray<Integer> bstArray = new BSTArray<>(15);

        bstArray.insert(5);
        bstArray.insert(3);
        bstArray.insert(7);
        bstArray.insert(1);
        bstArray.insert(4);
        bstArray.insert(8);
        bstArray.insert(6);

        bstArray.traverse(0);
        System.out.println();

        bstArray.LNR(0);
        System.out.println();

        System.out.println(bstArray.find(4));
        System.out.println(bstArray.find(2));

        bstArray.traverse(0);

        // two-child case:

        bstArray.delete(5);
        bstArray.traverse(0);

        // no-child case:

        bstArray.delete(1);
        bstArray.traverse(0);

        // one-child case:

        bstArray.delete(7);
        bstArray.traverse(0);

    }

}
