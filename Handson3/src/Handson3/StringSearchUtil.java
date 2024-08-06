package Handson3;


import java.util.function.Predicate;


public class StringSearchUtil {
	private String toSearch;

	public StringSearchUtil(String toSearch) {
		this.toSearch = toSearch;
	}

	public Predicate<String> startsWith(){
		return w->w.startsWith(toSearch);
	}
	public Predicate<String> endsWith(){
		return w->w.endsWith(toSearch);

	}
	public Predicate<String> contains(){
		return w->w.contains(toSearch);

	}
	public Predicate<String> equals(){
		return w->w.equals(toSearch);

	}
}
