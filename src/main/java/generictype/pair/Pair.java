package generictype.pair;

import java.util.Comparator;

public class Pair<E extends Comparable<E>>  {

    private E first;
    private E second;

    public Pair(E first, E second){
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public E max(Comparator<E> comparator){
        if (comparator.compare(first,second) > 0) return first;
        return second;
    }

    // first way to compare elements
    public E min(Comparator<E> comparator){
        if (comparator.compare(first,second) < 0) return first;
        return second;
    }

    public E max(){
        if (second.compareTo(first) > 0) return second;
        return first;
    }

    public E min(){
        if (second.compareTo(first) < 0) return second;
        return first;
    }

    @Override
    public String toString() {
        return "{" +"first=" + first +
                ", second=" + second +
                '}';
    }
}
