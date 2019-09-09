package generictype.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<E>  implements Initial,AbstractDescription,AbstractCollection<E> {

    private List<E> elements;
    protected int currentSize;


    public  Stack() {
        elements = new ArrayList<>(initialSize);
    }

    public void push(E item){
        elements.add(item);
    }

    public E pop() {
        if (elements.size() < 1) return null;
        return elements.remove(0);
    }

    public boolean isEmpty(){
        return  this.elements.size() == 0;
    }

    protected boolean isEmpty(int size){
        return size == 0;
    }


    @Override
    public String toString() {
        return this.getClass().getName()
        +"{"+ getClassFields()+"}";
    }

    @Override
    public String getClassFields() {
        return "elements="+this.elements;
    }
}
