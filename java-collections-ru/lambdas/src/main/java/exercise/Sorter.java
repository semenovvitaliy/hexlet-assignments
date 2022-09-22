package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> inList) {
        return inList.stream()
                .filter(searchMan -> searchMan.get("gender").equals("male"))
                .sorted(Comparator.comparing(birth -> birth.get("birthday")))
                .map(searchMan -> searchMan.get("name"))
                .collect(Collectors.toList());
    }
}
// END
