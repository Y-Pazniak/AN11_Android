import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main { //Проверка на цензуру
    public static void main(String[] args) {
        final String[] blackList = readFile(new File("E:/TMS/Homework/Git/Home_9/Task_9_3/black_list.txt"));
        final String[] text = readFile(new File("E:/TMS/Homework/Git/Home_9/Task_9_3/text.txt"));
        checkForStopWords(blackList, text);
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

    public static void checkForStopWords(final String[] blackList, final String[] text) { //проверить текст на стоп-слова
        boolean isTextOk = true;
        for (String blackWord : blackList) {
            for (String strForCheck : text) {
                if (strForCheck.toLowerCase().contains(blackWord)){
                    isTextOk = false;
                    System.out.println("Wrong word: \"" + blackWord + "\" at line: \"" + strForCheck + "\"");
                }
            }
        }
        if (isTextOk) {
            System.out.println("Your text is OK");
        }
    }
}
