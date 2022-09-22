package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    public static Map<String, Integer> getWordCount(String inString) {
        String[] splittedString =  inString.split(" ");
        Map<String, Integer> dictionary = new HashMap<>();
        if (inString.length() == 0) {
            return dictionary;
        }
        for (int i = 0; i < splittedString.length; i++) {
                dictionary.put(splittedString[i], dictionary.getOrDefault(splittedString[i], 0) + 1);
        }
        return dictionary;
    }
    public static String toString(Map<String, Integer> dictionary) {
        if (dictionary.isEmpty()) {
            return "{}";
        }
        StringBuilder str = new StringBuilder("{");
        for (Map.Entry<String, Integer> diction: dictionary.entrySet()) {
            str.append("\n  " + diction.getKey() + ": " + diction.getValue());
        }
        str.append("\n}");
        return str.toString();
    }
}
//END
