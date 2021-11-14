import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String line = readLine(); //Пользователь вводит набор чисел в виде одной строки "1, 2, 3, 4, 4, 5"
        String[] arrIntegers = splitLine(line);
        printUniqSymbols(arrIntegers); //Избавиться от повторяющихся элементов в строке и вывести результат на экран
    }

    public static String readLine() {
        String line = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            line = bufferedReader.readLine();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return line;
    }

    private static String[] splitLine(final String line) {
        if ((line != null) && (!line.isEmpty())) {
            return line.trim().split(",\\s+");
        } else return new String[]{};
    }

    private static void printUniqSymbols(final String[] arrIntegers) {
        Set<String> strings = new HashSet<>(Arrays.asList(arrIntegers));
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
