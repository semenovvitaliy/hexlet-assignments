package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
class PairedTag extends Tag {
    private final String tagBody;
    private final List<Tag> subTagList;

    public PairedTag(String tagName,
                     Map<String, String> tagAttributes,
                     String tagBody,
                     List<Tag> subTagList) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.subTagList = subTagList;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("<");
        s.append(super.getTagName());
        for (Map.Entry<String, String> entry : super.getTagAttributes().entrySet())
            s.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        s.append(">");
        for (Tag each : this.subTagList) {
            s.append(each.toString());
        }
        s.append(this.tagBody).append("</").append(super.getTagName()).append(">");
        return s.toString();
    }
}
// END
