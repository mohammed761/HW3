package search8.string;

import search8.SearchEngine;
import search8.string.StringSearchUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
    	long start=System.currentTimeMillis();
        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Hobbit.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	data.addAll(Arrays.asList(line.split("\\s+")));
            }
            SearchEngine<String> searchEngine = new SearchEngine<>();
            searchEngine.setData(data);
            

            List<String> longWords = data.stream()
                    .filter(word -> word.length() > 5) 
                    .collect(Collectors.toList());
            System.out.println(longWords.get(1));
            longWords.forEach(System.out::println);
            

            

            StringSearchUtils utils = new StringSearchUtils("a");

            List<String> containsA = utils.contains(data);
            containsA.forEach(System.out::println);
            List<String> startsWithA = utils.startsWith(data);
            startsWithA.forEach(System.out::println);

            List<String> endsWithA = utils.endsWith(data);
            endsWithA.forEach(System.out::println);

            List<String> topThree = StringSearchUtils.topThree(data);
            topThree.forEach(System.out::println);
            long end=System.currentTimeMillis();
            System.out.println("Search time: " + (end-start) + " ms");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
