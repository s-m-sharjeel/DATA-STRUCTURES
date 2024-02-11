package Labs.Lab8;

import java.util.Objects;

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

        bst.traverse(bst.root);

        bst.LNR(bst.root);

        System.out.println();
        System.out.println(bst.heightCount(bst.root));

        System.out.println();
        System.out.println(bst.countTotal(bst.root));

        System.out.println();
        System.out.println(bst.countLeaf(bst.root));

        BST<Integer> bst1 = new BST<Integer>();

        bst1.insert(5);
        bst1.insert(3);
        bst1.insert(7);

        BST<Integer> bst2 = new BST<Integer>();

        bst2.insert(5);
        bst2.root.left = new Node<>(7);
        bst2.root.right = new Node<>(3);

        System.out.println(areMirror(bst1.root, bst2.root));

    }

    public static boolean areMirror(Node<Integer> a, Node<Integer> b) {

        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;

        if (!Objects.equals(a.data, b.data))
            return false;

        return areMirror(a.left, b.right) && areMirror(a.right, b.left);

    }

}
