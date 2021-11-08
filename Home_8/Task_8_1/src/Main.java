public class Main {
    public static void main(String[] args) {
        Car vaz2109 = new Car("VAZ-2109", 100, 500);
        Car vaz2107 = new Car("VAZ-2107", 80, 300);
        Car vaz2106 = new Car("VAZ-2106", 60, 50);

        try {
            while (true) {
                vaz2106.startEngine();
                vaz2107.startEngine();
                vaz2109.startEngine();
            }
        } catch (EngineNotStartException exc) {
            exc.printStackTrace();
            System.out.println("Engine not start!");
            exc.callTowTruck();
        }
    }
}
