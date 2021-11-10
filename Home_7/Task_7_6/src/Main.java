import java.util.Locale;

public class Main { //"Дан текст, отсортировать слова в тексте по их количеству" - немножко неоднозначное задание, я понял его как "отсортировать текст по длине слов в нем", если неправильно - напишите, я переделаю
    public static void main(String[] args) {
        String text = "ТЕСТ 1 Когда я закончу учебу, стану программистом и найду себе работу. " +
                "Я буду старательно работать и мне заплатят зарплату. " +
                "Когда я получу ТЕСТ 2 зарплату, я перестану собирать бутылки и картон. " +
                "Я смогу купить себе еду, одежду, перестану жить на теплотрассе. " +
                "Я хорошо умоюсь, побреюсь, постригусь и расчешу волосы. " +
                "А еще я приглашу на ТЕСТ 3 свидание продавщицу по имени Таня из гастронома на улице Богдановича. " +
                "Мне нравится учиться, потому что у меня есть цель. " +
                "Миямото Мусаи учил, что у самурая не должно быть цели, только путь. " +
                "В этом заключается дуализм ТЕСТ 4 восточной философии: мы не должны стремиться к достижению цели любыми средствами, а должны достойно пройти путь к ней. " +
                "Всецелое посвящение себя пути к цели не отрицает догматики Дзен-буддизма, а доктрина дзена дополняет философию самурая поиска пути. " +
                "Продавщица Таня красивая. Я подарю ТЕСТ 5 ей цветы и шоколад. " +
                "Клен обронил последние листья. Осеннее небо все ниже. Скоро будет зима. " +
                "Trois bouteilles de vodka. ТЕСТ 6 Avec plaisir.";

        sortAndPrint(text); //запускаем метод сортировки и там же (в методе) печатаем, что получилось, в консоль
    }

    public static void sortAndPrint(final String text) {
        String[] arrText = text.split("[.,:;!?\"\\s+]");
        //нам сказали, что нежелательно использовать Map, иначе можно было бы решить проще через HashMap<String, Integer>
        //ниже я попробовал через обычные массивы

        int[] arrCount = createIntArray(arrText); //здесь создаю параллельный массив и записываю в него к-во упоминаний слова в тексте
        sortArrays(arrText, arrCount); //здесь вызываю метод сортировки этих массивов по убыванию
        deleteExcessPositions(arrText, arrCount); //здесь запускается метод удаления лишних значений из массивов, чтобы упорядочить вывод в будущем
        printWordsAndCounts(arrText, arrCount); //тут печатаем что получилось в консоль

    }

    private static void printWordsAndCounts(String[] arrText, int[] arrCount) {
        for (int i = 0; i < arrText.length; i++) {
            if ((arrText[i] != null) && (!arrText[i].isEmpty())) {
                System.out.println(arrText[i] + " - " + arrCount[i]);
            }
        }
    }

    private static int[] createIntArray(String[] arrText) {
        int[] arrCount = new int[arrText.length];
        for (int i = 0; i < arrText.length; i++) { //здесь создаю параллельный массив и записываю в него к-во упоминаний слова в тексте
            for (int j = i; j < arrText.length; j++) {
                if (arrText[i].equalsIgnoreCase(arrText[j])) {
                    arrCount[i]++;
                }
            }
        }
        return arrCount;
    }

    private static void sortArrays(String[] arrText, int[] arrCount) {
        //здесь я запускаю сортировку двух массивов параллельно друг другу
        boolean needSortNext = true;
        String tempString;
        int tempInt;
        while (needSortNext) {
            needSortNext = false;
            for (int i = 0; i < arrCount.length - 1; i++) {
                if (arrCount[i + 1] > arrCount[i]) {
                    needSortNext = true;
                    tempString = arrText[i];
                    tempInt = arrCount[i];

                    arrText[i] = arrText[i + 1];
                    arrText[i + 1] = tempString;

                    arrCount[i] = arrCount[i + 1];
                    arrCount[i + 1] = tempInt;
                }
            }
        }
    }

    private static void deleteExcessPositions(String[] arrText, int[] arrCount) {
        for (int i = 0; i < arrText.length - 1; i++) {
            arrText[i] = arrText[i].toLowerCase();
            for (int j = i + 1; j < arrText.length; j++) { //если слово встречается в массиве более 1 раза, все последующие разы мы слово "обнуляем" - делаем пустым
                if (arrText[i].equalsIgnoreCase(arrText[j])) {
                    arrText[j] = "";
                    arrCount[j] = 0;
                }
            }
        }
    }


//    public static String[] sort(final String text) { //метод сортировки
//        String[] arr = text.split("[.,:;!?\"\\s+]"); //регулярное выражение, чтобы разбить текст на слова, отсечь запятые и прочие знаки препинания
//        boolean needSortNext = true; //булевая переменная для сортировки пузырьком
//        String temp; //стринг для хранения данных
//        while (needSortNext) { //запускаем сортировку пузырьком (другие я просто не умею делать)
//            needSortNext = false;
//            for (int i = 0; i < arr.length - 1; i++) {
//                if (arr[i + 1].length() > arr[i].length()) {
//                    needSortNext = true;
//                    temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                }
//            }
//        }
//        return arr; //возвращаем отсортированный массив
//    }
}
