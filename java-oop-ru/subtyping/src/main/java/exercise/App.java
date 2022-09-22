package exercise;

import java.util.Map;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage inMap) {
        KeyValueStorage tempMap = new InMemoryKV(inMap.toMap());
        for (Map.Entry<String, String> each: tempMap.toMap().entrySet()) {
            inMap.unset(each.getKey());
        }
        for (Map.Entry<String, String> each: tempMap.toMap().entrySet()) {
            inMap.set(each.getValue(), each.getKey());
        }
    }
}
// END
