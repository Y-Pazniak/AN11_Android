public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100];
        GlobalCounter globalCounter = new GlobalCounter();

        Thread t1 = new Thread(new ArrayFiller(arr, globalCounter));
        Thread t2 = new Thread(new ArrayFiller(arr, globalCounter));
        Thread t3 = new Thread(new ArrayFiller(arr, globalCounter));

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        for (int i = 0; i < arr.length; i++) {
            System.out.println("i: " + i + " - " + arr[i]);
        }

    }
}
