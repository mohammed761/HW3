package Handson2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class Test2parallelStream {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        long start=System.currentTimeMillis();

        try (BufferedReader reader = new BufferedReader(new FileReader("Hobbit.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.addAll(Arrays.asList(line.split("\\s+")));
            }
            System.out.println("Number of words: " + data.size());

            // Count unique words
            HashSet<String> hashs = new HashSet<>(data);
            System.out.println("Number of unique words: " + hashs.size());

            // Find first word using parallel stream
            data.parallelStream().findFirst().ifPresent(word -> System.out.println("First word: " + word));

            // Find first word after sorting using parallel stream
            data.parallelStream()
                .filter(word -> !word.isEmpty())
                .filter(word -> word.matches("[a-zA-Z]+"))
                .sorted()
                .findFirst()
                .ifPresent(word -> System.out.println("First word after sorted: " + word));

            // Find first word after sorting in descending order using parallel stream
            data.parallelStream()
                .filter(word -> !word.isEmpty())
                .filter(word -> word.matches("[a-zA-Z]+"))
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .ifPresent(word -> System.out.println("First word after sorted (descending): " + word));
            long end=System.currentTimeMillis();
            System.out.println("Search time with parallelStream: " + (end-start) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
