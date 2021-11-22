import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main { //Проверка на цензуру
    private static List<String> synchronizedList;
    private static final int THREADS_COUNT = 8;
    public static boolean isTextOk = true;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        final String[] blackList = readFile(new File("E:/TMS/Homework/Git/Home_11/Task_11_3/src/black_list.txt"));
        final String[] text = readFile(new File("E:/TMS/Homework/Git/Home_11/Task_11_3/src/text.txt"));

        Thread[] threads = createAndStartThreads(blackList, text);
        for (Thread t : threads) {
            t.join();
        }

//        checkForStopWords(blackList, text);

        System.out.println("Array of wrong lines size: " + synchronizedList.size());
        System.out.println("Program time: " + (System.currentTimeMillis() - start));
        if (isTextOk) {
            System.out.println("Text is OK");
        }
    }

    public static String[] readFile(final File file) { //прочитать файл и вернуть его содержимое построчно
        ArrayList<String> words = new ArrayList<>();
        String readString;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((readString = bufferedReader.readLine()) != null) {
                if (!readString.isEmpty()) {
                    words.add(readString);
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return words.toArray(new String[0]);
    }

    private static Thread[] createAndStartThreads(final String[] blackList, final String[] text) {
        Thread[] threads = new Thread[THREADS_COUNT];
        int threadStep = text.length / THREADS_COUNT;
        synchronizedList = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < THREADS_COUNT; i++) {
            int localStart = threadStep * i;
            int localFinish = threadStep * (i + 1);

            Thread t = new Thread(new ThreadReader(localStart, localFinish, blackList, text, synchronizedList));
            threads[i] = t;
            t.start();
        }
        return threads;
    }

//    private static void checkForStopWords(final String[] blackList, final String[] text) {
//        for (String blackWord : blackList) {
//            for (String line : text) {
//                String[] words = line.trim().split("[.!?,:;«»\"\\s+]");
//                for (String word : words) {
//                    if (blackWord.equalsIgnoreCase(word)) {
//                        System.out.println("Wrong word: \"" + blackWord + "\" at line: \"" + line + "\"");
//                        synchronizedList.add(line);
//                    }
//                }
//            }
//        }
//    }
}