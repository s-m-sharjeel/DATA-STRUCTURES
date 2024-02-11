package Labs.Lab7;

public class ArrayStack<T extends Comparable<T>> {

    T stackList[];
    int top;

    // constructor
    public ArrayStack(int size){
        stackList = (T[]) new Comparable[size];
        top = -1;
    }

    public void push(T c) {

        // can not push as array is full
        if (isFull())
            return;

        top++;
        stackList[top] = c;

    }

    public T pop() {

        // can not pop as array is empty
        if (isEmpty())
            return null;

        return stackList[top--];

    }

    public boolean isEmpty() {

        return top == -1;

    }

    public boolean isFull(){

        return top == stackList.length - 1;

    }

    /**
     * @return the value at the top without removing it from the list
     */
    public T peek() {

        // can not pop as array is empty
        if (isEmpty())
            return null;

        return stackList[top];

    }

}

