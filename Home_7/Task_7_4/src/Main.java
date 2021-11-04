public class Main { //Найти слово, в котором число различных символов минимально
    public static void main(String[] args) {
        String s1 = "myla ramy ffafafaaaafffff fffffaaaaaaa fafafafafa 000000 111 666 111122222 12121212 1112223";
        findMinLetters(s1);
    }

    public static boolean findMinLetters(final String string) { //метод находит слово с минимальным числом вариантов символов и вывоит на экран
        String[] arr = string.split("\\s+"); //разбиваем текст на слова
        int min = findMinLettersCount(arr); //ищем число с минимальной вариацией символов
        for (String s : arr) { //запускаем обход и сравниваем, будет ли данное слово словом с минимальным к-вом вариантов
            if (min == findDifferentLetterCount(s)) { //если будет - то выводим на экран и завершаем обход (так требовалось в условии)
                System.out.println(s);
                return true;
            }
        }
        return false;
    }

    public static int findMinLettersCount(final String[] strings) { //метод, который ищет минимальное к-во символов в словах
        int min = Integer.MAX_VALUE;
        int local = 0;
        for (String s : strings) {
            if (s.length() > 1) { //проверяем слова, длиннее 1 символа
                local = findDifferentLetterCount(s);//передаем в метод подсчета к-ва разных символов
            }
            if (min > local) {
                min = local;
            }
        }
        return min; //возвращаем минимальное к-во символов
    }

    public static int findDifferentLetterCount(final String s) {  //этот метод считает, сколько разных символов в переданном слове
        int local = 1; //если мы получили слово, то как минимум 1 символ в слове уже есть
        for (int i = 0; i < s.length() - 1; i++) {
            if (!s.substring(i + 1).contains(String.valueOf(s.charAt(i)))) { //отсекаем проверяемый символв и символы перед ним и смотрим, есть ли такой символ - если больше его нет, а строка продолжается, увеличиваем к-во символов
                local++;
            }
        }
        System.out.println(s + "  - symbols - " + local);
        return local; //возвращаем, сколько разных символов в слове
    }
}
