package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {

    private HashMap<String, String> myMap = new HashMap<>();

    public InMemoryKV(Map<String, String> inMap) {
        this.myMap.putAll(inMap);
    }

    @Override
    public void set(String key, String value) {
        this.myMap.put(key, value);
    }

    @Override
    public void unset(String key) {
        myMap.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.myMap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> outMap = new HashMap<>(myMap);
        return outMap;
    }
}
// END
