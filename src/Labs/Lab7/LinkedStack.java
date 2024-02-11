package Labs.Lab7;

public class LinkedStack <T extends Comparable<T>> {

    class StackNode <T> {

        StackNode<T> next;
        T info;

        public StackNode(T info) {
            this.info = info;
        }
    }

    StackNode<T> top;

    public void push(T c) {

        StackNode<T> newNode = new StackNode<>(c);
        newNode.next = top;
        top = newNode;

    }

    public T pop() {

        // stack is empty
        if (isEmpty())
            return null;

        StackNode<T> temp = top;
        top = top.next;
        return temp.info;

    }

    public boolean isEmpty() {

        return top == null;

    }

    public T peek() {

        // stack is empty
        if (isEmpty())
            return null;

        return top.info;


    }

}