package concurrency;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class DataReader {

    public DataReader() {
    }

    public static List<String> readAllWords(String pathToResource) {

        ArrayList<String> collect = null;
        try (Stream<String> lines = Files.lines(Paths.get(pathToResource), Charset.defaultCharset())) {
            collect = lines.flatMap(line -> Arrays.stream(line.split("[\\p{Punct}\\s]+")))
                    .filter(word -> word.length() > 0)
                    .map(String::trim)
                    .collect(toCollection(ArrayList::new));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return collect;
    }

    public static String readAllWordsFromBigFiles(String pathToResource) throws IOException {
        CharBuffer charBuffer = null;
        FileChannel chanel = FileChannel.open(Paths.get(pathToResource), StandardOpenOption.READ);
        MappedByteBuffer buffer = chanel.map(FileChannel.MapMode.READ_ONLY, 0, chanel.size());
        if (buffer != null) charBuffer = StandardCharsets.UTF_8.decode(buffer);
        chanel.close();

        return (charBuffer != null) ? charBuffer.toString() : "";
    }

    public static long getNumberOfOccurrencesWord(String searchWord, Path pathToFile) {
        return getNumberOfOccurrencesWord(searchWord, pathToFile, true);
    }

    public  static long getNumberOfOccurrencesWord(String searchWord, Path pathToFile, boolean matchCase) {
        List<String> words = readAllWords(pathToFile.toString());
        Stream<String> wordsStream = words.parallelStream();

        if (!matchCase) {
            final String toFind = searchWord.toLowerCase();
            return wordsStream.filter(word -> word.toLowerCase().equals(toFind)).count();
        }
        return wordsStream.filter(word -> word.equals(searchWord)).count();
    }

}
