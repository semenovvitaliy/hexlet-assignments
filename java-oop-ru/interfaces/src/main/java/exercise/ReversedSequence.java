package exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

// BEGIN
class ReversedSequence implements CharSequence {

    private final String s;

    public ReversedSequence(String s) {
        this.s = Arrays.stream(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(toString()));
    }

    @Override
    public int length() {
        return s.length();
    }

    @Override
    public char charAt(int i) {
        return s.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return s.subSequence(i, i1);
    }
}
// END
