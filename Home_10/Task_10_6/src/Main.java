import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> setFirst = new HashSet<>(Arrays.asList("foo", "bar", "baz"));
        Set<String> setSecond = new HashSet<>(Arrays.asList("fred", "foo", "qux", "bar"));
        Set<String> setThird = new HashSet<>(Arrays.asList("osе", "rol", "foo", "qux", "xyzzy", "zed", "bar"));
        Set<String> unionSet = union(setFirst, setSecond, setThird);
        Set<String> intersectSet = intersect(setFirst, setSecond, setThird);
        printSet(unionSet);
        System.out.println("***");
        printSet(intersectSet);
    }

    @SafeVarargs
    private static <T> Set<T> union(Set<T>... sets) { //операция объединения
        if (sets != null) {
            Set<T> localSet = new HashSet<>(sets[0]);
            for (Set<T> s : sets) {
                localSet.addAll(s);
            }
            return localSet;
        } else return new HashSet<>();
    }

    @SafeVarargs
    private static <T> Set<T> intersect(Set<T>... sets) { //операция пересечения
        if (sets != null) {
            Set<T> localSet = new HashSet<>(sets[0]);
            for (Set<T> s : sets) {
                localSet.retainAll(s);
            }
            return localSet;
        } else return new HashSet<>();
    }


    private static <T> void printSet(Set<T> set) {
        for (var v : set) {
            System.out.println(v);
        }
    }
}
