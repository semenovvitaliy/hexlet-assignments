package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        LinkedHashMap<String, String> outMap = new LinkedHashMap<>();
        TreeSet<String> keysTree = new TreeSet<>(map1.keySet());
        keysTree.addAll(map2.keySet());

        for (String keyEntry : keysTree) {
            if (!map1.containsKey(keyEntry)) {
                outMap.put(keyEntry, "added");
            } else if (!map2.containsKey(keyEntry)) {
                outMap.put(keyEntry, "deleted");
            } else if (map1.get(keyEntry).equals(map2.get(keyEntry))) {
                outMap.put(keyEntry, "unchanged");
            } else {
                outMap.put(keyEntry, "changed");
            }
        }
        return outMap;
    }
}
//END
