import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main { //Проверка на цензуру
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        final String[] blackList = readFile(new File("E:/TMS/Homework/Git/Home_11/Task_11_3/src/black_list.txt"));
        final String[] text = readFile(new File("E:/TMS/Homework/Git/Home_11/Task_11_3/src/text.txt"));
        CheckStopWords checkStopWords = new CheckStopWords(blackList, text);
        Thread thread = new Thread(checkStopWords);
        thread.start();
        thread.join();
        System.out.println(System.currentTimeMillis() - start);
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
}