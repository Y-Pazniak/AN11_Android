public class ArrayFiller implements Runnable {
    private final int[] arr;
    private final GlobalCounter counter;
    private int count;

    public ArrayFiller(final int[] arr, final GlobalCounter counter) {
        this.arr = arr;
        this.counter = counter;
        count = 0;
    }

    @Override
    public void run() {
        int local;
        while ((local = counter.getAndIncrement()) < arr.length) {
            int toPut = (int) (Math.random() * 100);
            //System.out.println(Thread.currentThread().getName() + " - " + toPut);
            arr[local] = toPut;
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " counter is " + count);
    }
}
