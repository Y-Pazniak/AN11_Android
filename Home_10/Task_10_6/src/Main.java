import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> setFirst = new HashSet<>(Arrays.asList("foo", "bar", "baz"));
        Set<String> setSecond = new HashSet<>(Arrays.asList("fred", "foo", "qux", "xyzzy", "bar"));
        //union(setFirst, setSecond);
        intersect(setFirst, setSecond);
        printSet(setFirst);
    }

    private static <T> void union(Set<T> setFirst, Set<T> setSecond) { //операция объединения
        setFirst.addAll(setSecond);
    }

    private static <T> void intersect(Set<T> setFirst, Set<T> setSecond) { //операция пересечения
        setFirst.retainAll(setSecond);
    }

    private static <T> void printSet(Set<T> setFirst) {
        for (var v : setFirst) {
            System.out.println(v);
        }
    }
}
