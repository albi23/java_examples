package generictype.stack;

//import java.util.Stack;

public class Test {

    public static void main(String[] args) {

        System.out.println("--- Stack ver 1. ---");
        Stack<String> myStack = new Stack<>();
        myStack.push("Test");
        myStack.push("Test 2");
        myStack.push("Test 3");

        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());

        System.out.println("\n\n--- Stack ver 2. ---");
        Stack2<Integer> myStack2 = new Stack2<>(Integer.class);
        for (int i = 0; i < 6; i++) myStack2.push(i);

        System.out.println(myStack2.toString());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.toString());

        System.out.println("\n\n--- Stack ver 3. ---");

        Stack<Character> myStack3 = new Stack3<>();
        myStack3.push('A');
        myStack3.push('B');
        myStack3.push('C');
        System.out.println(myStack3.toString());
        System.out.println(myStack3.pop() instanceof  Character);
        char test = myStack3.pop();
        System.out.println(test);
    }
}
