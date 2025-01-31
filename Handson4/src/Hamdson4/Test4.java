package Hamdson4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {

	public static void main(String[] args) {
        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Hobbit.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	data.addAll(Arrays.asList(line.split("\\s+")));
            }
        final int counter[]= {0};
        data.stream().forEach(word->{
        	counter[0]+=word.length();
        	});
        System.out.println("Sum of all letters in the text: " + counter[0]);

        IntSummaryStatistics stats = data.stream()
        		.filter(word->!word.isEmpty())
                .mapToInt(String::length)
                .summaryStatistics();

//       
//        System.out.println("Total sum of letters: " + stats.getSum());
//        System.out.println("Average word length: " + stats.getAverage());
//        System.out.println("Minimum word length: " + stats.getMin());
//        System.out.println("Maximum word length: " + stats.getMax());
        
        
        Map<Character, List<String>> groupedByFirstLetter = data.stream()
                .filter(word -> !word.isEmpty()) 
                .filter(word -> word.matches("[a-zA-Z]+"))
                .distinct() 
                .collect(Collectors.groupingBy(word -> Character.toLowerCase(word.charAt(0))));

      
        groupedByFirstLetter.forEach((key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        });
        
        
        Map<Character, Long>   wordCount = data.stream()
                .filter(word -> !word.isEmpty()) 
                .filter(word -> word.matches("[a-zA-Z]+"))
                .collect(Collectors.groupingBy(
                        word -> Character.toLowerCase(word.charAt(0)),
                        Collectors.counting()
                ));
        
        
        wordCount.forEach((key,value)->{
        	System.out.println("Key: " + key + ", Count: " + value);
        });
        
        
        Map<Boolean, List<String>> words = data.stream()
                .collect(Collectors.partitioningBy(word ->
                        word.matches(".*[aeiu].*")));


        System.out.println("Words without 'a', 'e', 'i', 'u': " + words.get(false));
        
        
        List<String> word1= data.stream()
                .filter(word -> !word.isEmpty()) 
                .filter(word -> word.matches("[a-zA-Z]+")) 
                .distinct() 
                .collect(Collectors.toList());

        Optional<String> longestWord=word1.stream()
        							 .reduce((w1,w2)->w1.length()>=w2.length()?w1:w2);
        Optional<String> shortestWord=word1.stream()
				 .reduce((w1,w2)->w1.length()<=w2.length()?w1:w2);
        
        longestWord.ifPresent(word -> System.out.println("Longest word: " + word));
        shortestWord.ifPresent(word -> System.out.println("Shortes word: " + word));

        }catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}
}
