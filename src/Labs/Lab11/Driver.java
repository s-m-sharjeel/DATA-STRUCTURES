package Labs.Lab11;

class Driver {

    public static void main(String[] args) {

        // question 1:

        MaxHeapTree<Integer> tree = new MaxHeapTree<>(20);
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(7);
        tree.insert(19);
        tree.insert(8);
        tree.insert(17);
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);
        tree.insert(21);
        System.out.println(tree);

        System.out.println(tree.extractMax());
        System.out.println(tree.getMax());

        System.out.println(tree);

        tree.update(9, 1);
        tree.remove(9);
        tree.remove(5);
        tree.remove(7);

        System.out.println(tree);

        MinHeapTree<Integer> minHeap = new MinHeapTree<>(20);

        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(9);
        minHeap.insert(7);
        minHeap.insert(19);
        minHeap.insert(8);
        minHeap.insert(17);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(21);

        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
    }

}