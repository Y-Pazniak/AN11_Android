public class Main {
    public static void main(String[] args) {
        Global global = new Global();

        Counter counter = new Counter(global);
        Thread counterThread = new Thread(counter);

        Printer printer = new Printer(global);
        Thread printerThread = new Thread(printer);

        counterThread.start();
        printerThread.start();
    }
}