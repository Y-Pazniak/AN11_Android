public class HeavyBox implements Comparable<HeavyBox>{
    private final int id;
    private final int weight;

    @Override
    public String toString() {
        return "[" + id + "] " + weight;
    }

    @Override
    public int compareTo(final HeavyBox o) {
        return weight - o.getWeight();
    }

    public HeavyBox(final int weight) {
        this.weight = weight;
        this.id = weight * ((int)((Math.random() * 1000)) * 31);
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }
}
