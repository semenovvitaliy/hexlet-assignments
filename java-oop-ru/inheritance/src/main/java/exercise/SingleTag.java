package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> tagAttributes) {
        super(tagName, tagAttributes);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("<");
        s.append(super.getTagName());
        for (Map.Entry<String, String> entry : super.getTagAttributes().entrySet()) {
            s.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        s.append(">");
        return s.toString();
    }
}
// END
