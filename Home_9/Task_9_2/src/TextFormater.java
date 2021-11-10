import java.io.*;

public class TextFormater { //вообще мне кажется, что задание не очень в ООП-стиле составлено
    //я бы вынес методы "считать содержимое файла", "разбить файл по предложениям" и "создать и заполнить новый файл" в отдельные методы
    //но по заданию написано 2 метода создать ¯\_(ツ)_/¯
    public static void main(String[] args) {
        final StringBuilder stringBuilder = new StringBuilder();
        String readStr;
        final File result = new File("E:/TMS/Homework/Git/Home_9/Task_9_2/result.txt");
        final File source = new File("E:/TMS/Homework/Git/Home_9/Task_9_2/text.txt");

        //читаем файл - по уму, лучше в отдельном методе
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            while ((readStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(readStr).append(" ");
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        //здесь считанное из файла разбиваем по предложениям и заполняем новый файл - тоже лучше бы в отдельный метод
        String[] sentences = stringBuilder.toString().split("[.!?]"); //тут разбиваем по предложениям - предложения могут оканчиваться на эти знаки препинания
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(result))) {
            for (String s : sentences) {
                if (s != null && !s.isEmpty()) {
                    int countWords = (countWords(s));
                    if (findPalindrome(s) || ((countWords) > 2 && (countWords < 6))) {
                        bufferedWriter.write(s + "\n");
                    }
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static int countWords(String str) { //тут считаем слова в строке
        int count = 0;
        final String[] arr = str.trim().split("[— \\s+]"); //тут разбиваем на слова - слова могут разделять пробелами, тире не является словом, остальные знаки препинания прилипают к словам и не имеют значения
        for (String s : arr) {
            if ((s != null) && (!s.isEmpty()))
                count++;
        }
        return count;
    }

    public static boolean findPalindrome(String str) { //тут проверяем палиндромность
        String[] arr = str.trim().split("[,:;«»\"\\s+]"); //тут отсекаем всякий мусор типа знаков препинания, кавычек и прочих штук, чтобы проверить чисто слово
        for (String s : arr) {
            if ((s != null) && (s.length() > 2)) {
                if (s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
