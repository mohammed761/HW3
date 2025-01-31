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

public class Test2 {
	public static void main(String args[] ) {
        List<String> data = new ArrayList<>();
        long start=System.currentTimeMillis();

        try (BufferedReader reader = new BufferedReader(new FileReader("Hobbit.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	data.addAll(Arrays.asList(line.split("\\s+")));
            }
            System.out.println("Number of words: " + data.size());
            HashSet<String> hashs = new HashSet<String>();
            for(String st:data) {
            	hashs.add(st);
            }
            System.out.println("Number of unique words: " + hashs.size());
            data.stream().findFirst().ifPresent(word->System.out.println("first word:"+word));
            
            data.stream()
            .filter(word -> !word.isEmpty())
            .filter(word -> word.matches("[a-zA-Z]+")) 
            .sorted().findFirst()
            .ifPresent(word->System.out.println("first word after sorted:"+word));
            data.stream()
            .filter(word -> !word.isEmpty())
            .filter(word -> word.matches("[a-zA-Z]+")) 
            .sorted(Comparator.reverseOrder())
            .findFirst()
            .ifPresent(word->System.out.println("first word after sorted(descending):"+word));
            long end=System.currentTimeMillis();
            System.out.println("Search time: " + (end-start) + " ms");
            
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
