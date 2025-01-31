package search8.string;

import java.util.List;
import java.util.stream.Collectors;

public class StringSearchUtils {
	private String toSearch;

	public StringSearchUtils(String toSearch) {
		this.toSearch = toSearch;
	}
	
	public List<String> startsWith(List<String> data) {
		return data.stream()
				.filter((String s) -> s.startsWith(toSearch))
				.collect(Collectors.toList());
		
	}
	public List<String> endsWith(List<String> data) {
		return data.stream()
				.filter((String s) -> s.endsWith(toSearch))
				.collect(Collectors.toList());
		
	}
	public List<String> contains(List<String> data) {
		return data.stream()
				.filter((String s) -> s.contains(toSearch))
				.collect(Collectors.toList());
		
	}
	public static List<String> topThree(List<String> data) {
		return data.stream()
				.limit(3)
				.collect(Collectors.toList());
		
	}
	


}
