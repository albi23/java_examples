package concurrency;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class TestConcurrency {

    public static final String PathOFTestFile = "/src/testingFiles/";
    public static final String TestFile1 = "lotr.txt";
    public static final String TestFile2 = "KJB.txt";

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        testReadInputFile();
        testReadBigInputFile();

        /* Let's get occurrences specific word in different test files*/
        testMultiThread();
        singleThreadTest(); // threading is expensive


    }

    private static void testReadInputFile(){
        long start =  System.currentTimeMillis();
        List<String> returnedWords = DataReader.readAllWords(System.getProperty("user.dir") + PathOFTestFile + TestFile1);
        System.out.println("Time read : "+((System.currentTimeMillis()-start))+" ms");
        for (String word: returnedWords)  System.out.print(word+" | ");
    }

    private static  void testReadBigInputFile() throws IOException {
        long start1 =  System.currentTimeMillis();
        String dataFromFile = DataReader.readAllWordsFromBigFiles(System.getProperty("user.dir") + PathOFTestFile + TestFile2);
        System.out.println("Time 2 read : "+((System.currentTimeMillis()-start1))+" ms");
        System.out.println("Data from file : "+dataFromFile); // to see result
    }

    private static void testMultiThread() throws InterruptedException, ExecutionException {

        warmUp();

        System.out.println("\n\n*** Multi thread ***");
        long startTime = System.nanoTime();
        final String toFindWord = "The";
        Set<Path> paths = new HashSet<>();
        paths.add(Paths.get(System.getProperty("user.dir") + PathOFTestFile + TestFile1));
        paths.add(Paths.get(System.getProperty("user.dir") + PathOFTestFile + TestFile2));

        List<Callable<Long>> tasks = new ArrayList<>();
        for (Path path: paths)
            tasks.add(() -> DataReader.getNumberOfOccurrencesWord(toFindWord,path,false));

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Long>> results = executor.invokeAll(tasks);
        long sum = 0;
        for (Future<Long> result : results) sum+= result.get();
        executor.shutdown();

        System.out.println("Occurrences search word in files : "+sum);
        long resultTime = System.nanoTime() - startTime;
        System.out.println("Time of search : "+ resultTime+" ns, "+(resultTime/1_000_000)+" ms");
    }

    private static void singleThreadTest() {

        System.out.println("\n\n*** Single thread ***");
        warmUp();
        long startTime = System.nanoTime();
        final String toFindWord = "The";
        Set<Path> paths = new HashSet<>();
        paths.add(Paths.get(System.getProperty("user.dir") + PathOFTestFile + TestFile1));
        paths.add(Paths.get(System.getProperty("user.dir") + PathOFTestFile + TestFile2));

        long sum = 0;
        for (Path path: paths)
            sum +=DataReader.getNumberOfOccurrencesWord(toFindWord,path,false);

        System.out.println("Occurrences search word in files : "+sum);
        long resultTime = System.nanoTime() - startTime;
        System.out.println("Time of search : "+ resultTime+" ns, "+(resultTime/1_000_000)+" ms");
    }

    /* Warm-up for processors */
    private static void warmUp() {
        for (int i = 1; i < 1_000_000; i++) System.out.print("\r" +  String.format("%3.2f",(((double)i)/1_000_000)*100)+"%");
    }

}
