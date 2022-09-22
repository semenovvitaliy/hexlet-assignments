package exercise;

import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private final String tagName;
    private final Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String getTagName() {
        return this.tagName;
    }

    public Map<String, String> getTagAttributes() {
        return new LinkedHashMap<>(this.tagAttributes);
    }

    public abstract String toString();
}
// END
