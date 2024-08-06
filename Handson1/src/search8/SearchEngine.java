package search8;

import java.util.List;

public class SearchEngine<T> {
	private List<T> data;
	private long lastSearchTimeInMillis;
	public List<T> getData(){
		return data;
	}
	public void setData(List<T> data){
		this.data=data;
		
		
	}
	public long getLastSearchTimeInMillis() {
		return lastSearchTimeInMillis;
		
	}
	public  List<T> executeSearch (SearchTask<T> search){
	      long startTime = search.startSearch();
	      List<T> result = search.search(data);
	      long endTime = search.endSearch();
	      lastSearchTimeInMillis = endTime - startTime;
	      return result;
		
	}


}
