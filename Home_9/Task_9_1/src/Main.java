import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main { //В исходном файле находятся слова, каждое слово на новой строке.
    // После запуска программы должен создать файл, который будет содержать в себе только палиндромы.

    public static void main(String[] args) {
        final String sourceFile = "D:/test.txt";
        final String palindromeFile = "D:/palindrome.txt";
        String[] words = {"как", "козодой", "кот", "кабак", "кулебяка", "кок", "козел", "мадам", "расстегай", "шалаш", "шабаш", "черт"};
        fillTheFile(sourceFile, words); //в задании этого не было, но я создал файл через Java и тут же его заполнил палиндромами и не только
        readFileAndFillByPalindromes(sourceFile, palindromeFile); //тут создал пустой файл и записал в него только палиндромы
    }

    public static void fillTheFile(String address, String[] strings) { //метод для заполнения файла
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(address))) {
            for (String string : strings) {
                if (string != null && !string.isEmpty()) {
                    bufferedWriter.write(string);
                    bufferedWriter.append('\n');
                    bufferedWriter.flush();
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void readFileAndFillByPalindromes(final String sourceFile, final String palindromeFile) { //считываем содержимое файла и сохраняем в лист, лист возвращаем
        List<String> strings = new ArrayList<>(); //можно было в обычный массив, но это лишний метод писать бы пришлось - мне кажется, в лист в данной ситуации лучше сохранять
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile))) {
            while (bufferedReader.ready()) {
                String stringToCheck = bufferedReader.readLine();
                if (isPalindrome(stringToCheck)) {
                    strings.add(stringToCheck);
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        String[] arr = strings.toArray(new String[0]);
        fillTheFile(palindromeFile, arr);
    }

    private static boolean isPalindrome(final String stringToCheck) {
        if (stringToCheck.length() >= 3){
            return stringToCheck.equalsIgnoreCase(new StringBuilder(stringToCheck).reverse().toString());
        } else return false; //возвращаем палиндром ли это
    }
}