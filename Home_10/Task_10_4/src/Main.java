import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<HeavyBox> boxes = new TreeSet<>();
        for (int i = 100; i > 0; i--) {
            boxes.add(new HeavyBox(i));
        }

        for (HeavyBox hb : boxes) {
            System.out.println(hb.getWeight());
        }
    }
}
