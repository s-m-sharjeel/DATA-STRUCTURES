package Labs.Lab9;

public class BSTArray <T extends Comparable<T>> {

    T[] tree;

    public BSTArray() {

        tree = (T[]) new Comparable[10];

    }

    public BSTArray(int size) {

        tree = (T[]) new Comparable[size];

    }

    public void insert(T key) {

        if (isEmpty()) {
            tree[0] = key;
            return;
        }

        int i = 0;
        while(tree[i] != null){

            if (tree[i].compareTo(key) > 0) {
                i = (2 * i) + 1;
            } else if (tree[i].compareTo(key) < 0) {
                i = (2 * i) + 2;
            } else throw new RuntimeException("similar data found!\neach key must be unique!");

        }

        tree[i] = key;

    }

    public void traverse(int index) {

        if (isEmpty())
            throw new RuntimeException("tree is empty!");

        for (int i = index; i < tree.length; i++)
            System.out.print(tree[i] + " ");

        System.out.println();

    }

    public int find(T key) {

        int i = 0;
        while (tree[i] !=null && key.compareTo(tree[i]) != 0){

            if (tree[i].compareTo(key) > 0)
                i = (2 * i) + 1;
            else if (tree[i].compareTo(key) < 0)
                i = (2 * i) + 2;


        }

        if(tree[i] !=null && key.compareTo(tree[i])==0)
            return i;

        return -1;  // sentinel value in case no such key is found

    }

    public boolean isEmpty() {

        return tree[0] == null;

    }

    public void LNR(int index) {

        if (index >= tree.length || tree[index] == null)
            return;

        LNR((index * 2) + 1);
        System.out.print(tree[index] + " ");
        LNR((index * 2) + 2);

    }

    public void delNoChild(int index) {

        tree[index] = null;

    }

    public void delOneChild(int index) {

        if (tree[(index * 2) + 1] != null) {
            tree[index] = tree[(index * 2) + 1];
            tree[(index * 2) + 1] = null;
        } else {
            tree[index] = tree[(index * 2) + 2];
            tree[(index * 2) + 2] = null;
        }

    }

    public void delete(T key) {

        int index = find(key);

        if(tree[index]!=null && key.compareTo(tree[index])==0){

            if(tree[(index * 2) + 1]==null && tree[(index * 2) + 2]==null){ // no child case
                delNoChild(index);
            } // one child case
            else if((tree[(index * 2) + 1]!=null &&tree[(index * 2) + 2]==null)||((tree[(index * 2) + 1]==null && tree[(index * 2) + 2]!=null))){
                delOneChild(index);
            }
            else{
                int curr = (index * 2) + 2;
                while (tree[(curr * 2) + 1] != null) {
                    curr = (curr * 2) + 1;
                }

                tree[index] = tree[curr];

                if (tree[(curr * 2) + 2] == null)
                    delNoChild(curr);
                else delOneChild(curr);

            }
        }
        else System.out.println("key not found");

    }

}
