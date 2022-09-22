package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildAppartmentsList(List<Home> homeList, int n) {

        return homeList.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .map(Object::toString)
                .limit(n)
                .collect(Collectors.toList());
        }
}
// END
