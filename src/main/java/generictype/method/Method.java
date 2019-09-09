package generictype.method;

import generictype.pair.Pair;

import java.util.ArrayList;
import java.util.List;

public class Method {


    public static <T> T[] mySwap(int i, int j, T... args){
        T temp = args[i];
        args[i] = args[j];
        args[j] = temp;
        return args;
    }

    public static <T> List<T> mySwap(int i, int j, List<T> args){
        T temp = args.get(i);
        args.set(i, args.get(j));
        args.set(j, temp);
        return args;
    }

    public static <E> List<? extends E> appendExtendElements(List<? extends E> from, List<E> to) {
        to.addAll(from);
        return to;
    }

    public static <E> List<? super E> appendSuperElements(List<E> from, List<? super E> to) {
        for (Object item: from) {
            to.add((E)item);
        }
        return to;
    }

    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<Pair<E>> list){
        if (list.size() < 1) return null;
        E first = list.get(0).getFirst();
        E last = list.get(list.size()-1).getSecond();
        return new Pair<>(first,last);
    }
}
