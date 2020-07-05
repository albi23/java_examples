package stream;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {

                /* Iterator  to Stream */
        Iterator<Path> iterator = Paths.get("/usr/share/dict/words").iterator();
        Stream<Path> stream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
        stream.forEach(System.out::println);

        /* Stream generator with break condition (API 9+)*/
        Stream<Integer> iterate = Stream.iterate(1, y -> y < 1500, x -> x + x);

        codePoints("αΣσς żźćłóę 主江热").forEach(System.out::print);

    }

    /* Correct way to get code points in Java */
    public static Stream<String> codePoints(String s) {
        var result = new ArrayList<String>(s.length());
        for (int i = 0, j; i < s.length(); i = j) {
            j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i, j));
        }
        return result.stream();
    }
}
