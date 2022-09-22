package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbolsForCheck, String wordForCheck) {
        if (symbolsForCheck.equals("")) {
            return false;
        }
        List<String> listOfChar = new ArrayList<>(Arrays.asList(symbolsForCheck.split("")));

        for (int i = 0; i < wordForCheck.length(); i++) {
            String substringForFind = wordForCheck.substring(i, i + 1).toLowerCase();
            if (listOfChar.contains(substringForFind)) {
                listOfChar.remove(substringForFind);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
