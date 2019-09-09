package generictype.table;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {

        System.out.println("-- Table v1---");
        Table<Integer,Character> myTable = new Table<>();
        myTable.addValue(1,'A');
        myTable.addValue(1,'B');
        myTable.addValue(5,'C');
        System.out.println(myTable.toString());
        System.out.println(myTable.getValue(1));
        System.out.println(myTable.remove(1));
        System.out.println(myTable.toString());

        System.out.println("\n\n-- Table v2---");
        Table2<Integer,Float> myTable2 = new Table2<>();
        myTable2.addValue(1,5.01f);
        myTable2.addValue(1,121.34f);
        myTable2.addValue(5,1212.56f);
        System.out.println(myTable2.toString());
        System.out.println(myTable2.getValue(1));
        System.out.println(myTable2.remove(1));
        System.out.println(myTable2.toString());

    }
}
