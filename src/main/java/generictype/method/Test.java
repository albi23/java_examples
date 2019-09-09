package generictype.method;

import generictype.compay.Employee;
import generictype.compay.Manager;
import generictype.table.Entry;

import java.util.*;

public class Test {


    public static void main(String[] args) {

        Double[] result = Method.mySwap(0,1,1.1,2.2,3.3,4.4);
        System.out.println(Arrays.asList(result));
        System.out.println(result instanceof Double[]);

        @SuppressWarnings("unchecked")
        Entry<UUID, String>[] entries = (Entry<UUID, String>[]) new Entry<?, ?>[]{
                new Entry<>(UUID.randomUUID(), "first"),
                new Entry<>(UUID.randomUUID(), "second"),
                new Entry<>(UUID.randomUUID(), "third"),
                new Entry<>(UUID.randomUUID(), "fourth")
        }; // harder way to create array of generic

        System.out.println(Arrays.asList(entries));
        Method.mySwap(0,1,entries);
        System.out.println(Arrays.asList(entries));


        System.out.println("--- Entries 2 ---");
        // easiest way
        Entry<UUID, String> entry1 = new Entry<>(UUID.randomUUID(), "One");
        Entry<UUID, String> entry2 = new Entry<>(UUID.randomUUID(), "Two");
        Entry<UUID, String> entry3 = new Entry<>(UUID.randomUUID(), "Three");
        Entry<UUID, String> entry4 = new Entry<>(UUID.randomUUID(), "Four");
        ArrayList<Entry<UUID,String>> entries2 = new ArrayList<>(4);
        entries2.add(entry1);
        entries2.add(entry2);
        entries2.add(entry3);
        entries2.add(entry4);
        System.out.println(entries2);
        Method.mySwap(2, 3, entries2); // for lists
        System.out.println(entries2);


        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alan","Walker",2500.0f));
        employees.add(new Employee("Tom","Cruise",3400.0f));
        employees.add(new Manager("Tymek","Blue", 7200.0f,750.0f));

        ArrayList<Manager> managers = new ArrayList<>();
        managers.add(new Manager("Luis","Aoki", 6300.0f,770.0f));
        managers.add(new Manager("Danny","Avila", 8900.0f,560.0f));

        // filing list of employees with managers
        // note : 1) we can't add employees to managers list
        // note : 2) we can add managers to employees list

        System.out.println("\nBefore append :" +employees.toString());
        Method.appendSuperElements(managers,employees); // managers is subtype to employee => ( ? extends E)
        System.out.println("After append :" +employees.toString());

        ArrayList<Employee> employees2 = new ArrayList(){{add(new Employee("Employee 2", "Employee 2", 1111.f));}};
        ArrayList<Employee> managers2 = new ArrayList(){{add(new Manager("Manager 2", "Manager 2", 2222.2f, 30.0f));}};
        System.out.println("\n\nBefore append v2 : " +employees2.toString());
        Method.appendExtendElements(managers2,employees2); // employee is super to manager => ( ? super E)
        System.out.println("After append v2 : " +employees2.toString());

    }

}
