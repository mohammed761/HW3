package Handson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {

	public static void main(String[] args) {
        List<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Hobbit.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	data.addAll(Arrays.asList(line.split("\\s+")));
            }
            StringSearchUtil st= new StringSearchUtil("aba");
            boolean startsWith=data.stream().anyMatch(st.startsWith());
            boolean endWith=data.stream().anyMatch(st.endsWith());
            boolean contains=data.stream().anyMatch(st.contains());
            boolean equals=data.stream().anyMatch(st.equals());
            System.out.println("Any word starts with 'aba': " + startsWith);
            System.out.println("Any word ends with 'aba': " + endWith);
            System.out.println("Any word contains 'aba': " + contains);
            System.out.println("Any word equals 'aba': " + equals);
            
            data.stream()
            .filter(word -> !word.isEmpty()) 
            .map(word -> new AbstractMap.SimpleEntry<>(word, word.length())) 
            .distinct() 
            .forEach(entry -> System.out.println("Word: " + entry.getKey() + ", Length: " + entry.getValue()));

            System.out.println("Word after change i to I"); // printed only the word i changed
            data.stream()
            .filter(word->word.contains("i"))
            .map(word->word.replace('i', 'I'))
            .forEach(entry->System.out.println(entry));
            
            System.out.println("new linr every 20 word");
            final int[] count= {0};
            data.stream()
            .forEach(word->{
            	
            	System.out.print(word + " ");
            	count[0]++;
            	if(count[0]%20==0) {
            		System.out.println();
            	}
            });
            
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
