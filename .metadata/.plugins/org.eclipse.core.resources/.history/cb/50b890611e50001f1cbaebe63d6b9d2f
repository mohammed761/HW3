package search8;

import java.util.List;

public interface SearchTask<T> {
    public default long startSearch() {
        return System.currentTimeMillis();
    }

    public default long endSearch() {
        return System.currentTimeMillis();
    }

    public List<T> search(List<T> data);
}
