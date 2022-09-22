package exercise;

import java.beans.beancontext.BeanContextChild;
import java.sql.Array;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] inArray) {
        String[][] outArray = Arrays.stream(inArray)
                .map(s -> {
                    String[] strings = Arrays.stream(s)
                            .flatMap(t -> Arrays.stream(new String[]{t, t}))
                            .toArray(String[]::new);
                    return strings;
                })
                .flatMap(s -> Arrays.stream(new String[][]{s, s}))
                .toArray(String[][]::new);
        return outArray;
    }
}
// END
