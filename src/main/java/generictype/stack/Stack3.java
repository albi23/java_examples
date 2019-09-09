package generictype.stack;

import java.util.Arrays;

public class Stack3<E> extends Stack<E> {

    private Object[] elements;

    public Stack3() {
        this.elements = new Object[initialSize];
    }

    @Override
    public void push(E item) {
        if (currentSize < this.elements.length) {
            this.elements[currentSize] = item;
        } else {
            this.elements = Arrays.copyOf(this.elements, (currentSize + 1) * 2);
        }
        currentSize++;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        currentSize--;
        if (Math.round((double) currentSize / (double) this.elements.length) <= 0.25) {
            this.elements = Arrays.copyOf(this.elements, (int) Math.round((double) this.elements.length / 2));
        }
        return (E)this.elements[currentSize];
    }


    @Override
    public String getClassFields() {
        return  "elements=" + Arrays.toString(elements) +
                ", currentSize=" + currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.elements.length == 0;
    }
}
