package generictype.stack;

import java.util.Arrays;

public class Stack2<E> extends Stack<E> {

    private E[] elements;

    /* Using reflection*/
    public Stack2(Class<E> cl) {
        currentSize = 0;
        elements = (E[]) java.lang.reflect.Array.newInstance(cl, initialSize);
    }

    @Override
    public void push(E item) {
        if (currentSize < elements.length) {
            elements[currentSize] = item;
        } else {
            elements = Arrays.copyOf(elements, (currentSize + 1) * 2);
        }
        currentSize++;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        currentSize--;
        if (Math.round((double) currentSize / (double) elements.length) <= 0.25) {
            elements = Arrays.copyOf(elements, (int) Math.round((double) elements.length / 2));
        }
        return elements[currentSize];
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public String getClassFields() {
        return "elements=" + Arrays.toString(elements) +
                ", currentSize=" + currentSize;
    }
}
