package evaluationstask;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalancedString {

    private final static int MAX_SIZE = 100_000;
    private final static int MAX_VALUE = 1_000_000_000;


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    }

    /**
     * Balanced <<><><><><><<<>>> or not? -> each '<' can be repleaced by '<>' to balance string but
     * you have specified number of replacements  for each string, if not save in result list 0 else 1
     * expressions - list of string
     * maxReplacements - list of max replacements
     */
    public static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {

        if (expressions.size() != maxReplacements.size()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>(expressions.size());
        for (int i = 0; i < expressions.size(); i++) {

            final String expresion = expressions.get(i);
            final Integer replacements = maxReplacements.get(i);
            final int changes = countNeededChanges(expresion);
            if (changes == 0) {
                result.add(i, 1);
            } else if (changes < 0) {
                result.add(i, 0);
            } else {
                int toAdd = (changes <= replacements) ? 1 : 0;
                result.add(i, toAdd);
            }
        }
        return result;
    }


    private static int countNeededChanges(String expresion) {
        final char[] chars = expresion.toCharArray();
        Stack<Character> stack = new Stack<>();
        int neededRepairs = 0;
        for (Character c : chars) {
            if (c.equals('<')) stack.push('<');
            else {
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    neededRepairs++;
                }
            }
        }
        return (stack.size() > 0) ? -1 : neededRepairs;
    }
}
