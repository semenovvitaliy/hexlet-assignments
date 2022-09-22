package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> dictionary) {
        List<Map<String, String>> findedBooks = new ArrayList<>();

        for (Map<String, String> book: books) {
            boolean hasKey = true;
            for (Map.Entry<String, String> stringsDictionary : dictionary.entrySet()) {
                if (!book.getOrDefault(stringsDictionary.getKey(), "").equals(stringsDictionary.getValue())) {
                    hasKey = false;
                }
            }
            if (hasKey) {
                findedBooks.add(book);
            }
        }
        return findedBooks;
    }
}
//END
