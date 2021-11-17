import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] integers = new int[5];
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < integers.length; i++) {
                integers[i] = readInt(bufferedReader);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        int localMin = findMin(integers);
        int localMax = findMax(integers);
        System.out.println("Min: " + localMin + "\nMax: " + localMax);

    }

    private static int findMin(final int[] integers) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i : integers) {
                    if (min > i) {
                        min = i;
                    }
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return min;
    }

    private static int findMax(final int[] integers) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i : integers) {
                    if (max < i) {
                        max = i;
                    }
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return max;
    }

    public static int readInt(final BufferedReader bufferedReader) {
        System.out.println("Enter the number:");
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
