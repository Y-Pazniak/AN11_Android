public class Main { //Дана строка, найти предложение с наибольшим количеством слов полиндромов.
    public static void main(String[] args) {
        String text = "Казак на заказ строил шалаш. " +
                "\nРядом    дед чинил ротор. " +
                "\nЛежавший тут кот свернулся в комок, забывая недавний потоп." +
                "\n\"Радар не видит никаких мадам поблизости\", - подумал казак, прикидывая, стоит ли наведаться в кабак." +
                "\n- Снова на шабаш собрался? Ищи себе доход! - уловил его мысль дед.";
        printMaxPalindrome(text);
    }

    private static void printMaxPalindrome(final String text) { //это метод, выводит в консоль строку с самым большим количеством палиндромов (если строк несколько - выведет все)
        String[] strings = text.split("\\."); //тут я попытался в регулярные выражения и разбил строку на подстроки по принципу "после точки - новая строка"
        int max = findMaxPalindromeCount(strings); //здесь я нахожу максимальное к-во палиндромов в строке
        for (String s : strings) {  //здесь перебираю массив строк
            if (max == countPalindromeString(s)) { //если нахожу предложение по к-ву совпадающее с max - печатаю в консоль
                System.out.print(s + ".");
            }
        }
    }

    public static int findMaxPalindromeCount(final String[] strings) { //этот метод проверяет все строки и возвращает ЧИСЛО максимального количества палиндромов
        int max = 0;
        int local;
        for (String s : strings) {
            local = countPalindromeString(s); //этот метод будет считать к-во палиндромов в данной строке
            if (max < local) {
                max = local;
            }
        }
        return max;
    }

    public static int countPalindromeString(final String s) { //здесь мы принимаем строку и возвращаем к-во палиндромов в ней
        int local = 0;
        //String[] words = s.split("\\W+"); //как оказалось, эта регулярка не дружит с кириллицей - а жаль :(
        String[] words = s.split("[,:;!?\"\\s+]"); //здесь тоже попытался в регулярные выражения - убрал запятые, точки с запятой, другие мешающие знаки
        for (String word : words) {
            if (checkReverseWord(word)) { //сравнил: если слово длиннее 1 символа и перевернутое равно само себе - увеличиваем переменную на 1
                local++;
            }
        }
        return local;
    }

    public static boolean checkReverseWord(String word){
        return (word.length() > 1) && (word.equalsIgnoreCase((new StringBuilder(word).reverse()).toString()));
    }
}
