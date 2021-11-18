public class Counter implements Runnable {
    private Global global;

    public Counter(final Global global) {
        this.global = global;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            global.increaseSec();
        }
    }
}
