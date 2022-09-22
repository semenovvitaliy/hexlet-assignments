package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static String getForwardedVariables(String configString) {
        List<String> inStringArray = new ArrayList<>(Arrays.asList(configString.split("\n")));
        return inStringArray.stream()
                .filter(s -> s.startsWith("environment="))
                .map(s -> s.replace("environment=", "").replaceAll("\"", ""))
                .flatMap(s -> Arrays.stream(s.split(",")))
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
