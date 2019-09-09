package generictype.stack;

public interface AbstractCollection<E> {

    void push(E item);

    default boolean isEmpty() {
        return true;
    }

    default E pop() {
        return null;
    }
}
