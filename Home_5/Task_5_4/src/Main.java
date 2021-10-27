public class Main {
    public static void main(String[] args) throws InterruptedException {
        Shuttle shuttle = new Shuttle();
        SpaceX spaceX = new SpaceX();
        Soyuz soyuz = new Soyuz();

        Cosmodrome cosmodrome = new Cosmodrome();
        cosmodrome.start(spaceX);
        cosmodrome.start(soyuz);
        cosmodrome.start(shuttle);
    }
}
