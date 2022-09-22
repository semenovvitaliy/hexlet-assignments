package exercise;

import jdk.jshell.execution.Util;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {

    private String path = "";
    private Map<String, String> myMap = new HashMap<>();

    public FileKV(String path, Map<String, String> inMap) {
        this.path = path;
        myMap.putAll(inMap);
        Utils.writeFile(this.path, Utils.serialize(myMap));
        myMap.clear();
    }

    @Override
    public void set(String key, String value) {
        String s1 = "";
        String s = Utils.readFile(path, s1);
        myMap.putAll(Utils.unserialize(s));
        myMap.put(key, value);
        Utils.writeFile(this.path, Utils.serialize(myMap));
        myMap.clear();
    }

    @Override
    public void unset(String key) {
        String s1 = "";
        String s = Utils.readFile(path, s1);
        myMap.putAll(Utils.unserialize(s));
        myMap.remove(key);
        Utils.writeFile(this.path, Utils.serialize(myMap));
        myMap.clear();
    }

    @Override
    public String get(String key, String defaultValue) {
        String s1 = "";
        String s = Utils.readFile(path, s1);
        myMap.putAll(Utils.unserialize(s));
        String s2 = myMap.getOrDefault(key, defaultValue);
        myMap.clear();
        return s2;
    }

    @Override
    public Map<String, String> toMap() {
        String s1 = "";
        String s = Utils.readFile(path, s1);
        Map<String, String> copyMap = new HashMap<>();
        copyMap.putAll(Utils.unserialize(s));
        return copyMap;
    }
}
// END
