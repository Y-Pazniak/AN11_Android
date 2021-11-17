public class Printer implements Runnable {
    private Global global;

    public Printer(final Global global) {
        this.global = global;
    }

    @Override
    public void run() {
        while (true) {
            int sec = global.getSec();

            System.out.println("Regular sec: " + sec);
            if (sec % 5 == 0) {
                System.out.println("5 secs!");
            }
            if (sec % 7 == 0) {
                System.out.println("7 secs!");
            }
        }
    }
}
