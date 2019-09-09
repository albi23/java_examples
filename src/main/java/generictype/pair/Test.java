package generictype.pair;

import generictype.method.Method;
import generictype.table.Entry;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Pair<String> stringPair = new Pair<>("AA","BB");
        Pair<String> stringPair2 = new Pair<>("aa","bb");
        System.out.println("Smaller in pair: "+stringPair.min(String::compareTo)
        + ", greater in pair : "+stringPair.max(String::compareTo) +" , checking without comparator : min = "+
                stringPair.min()+",  max = "+stringPair.max());;

        ArrayList<Pair<String>> stringPairs = new ArrayList(2){{add(stringPair); add(stringPair2);}};
        System.out.println("First and last: "+Method.firstLast(stringPairs));

        Pair<Integer> secondPar = new Pair<>(5,6);
        System.out.println("Integer test : min = "+secondPar.min(Integer::compareTo)+" max = "+secondPar.max());


        Pair<Entry<String, Integer>> thirdPair = new Pair<>(new Entry<>("smaller", 10), new Entry<>("bigger", 20));
        System.out.println("More interesting example : " +thirdPair.max());

    }
}
