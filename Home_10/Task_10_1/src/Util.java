import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Util { //тут творится чертовщина - я чуть голову не сломал, пока осознал, что наворотил в прошлый раз в этой задаче
    public static final Scanner scanner = new Scanner(System.in);
    public static final BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

    public static void print(final String print) { //просто метод красоты, чтобы меньше писать в мейне
        System.out.println(print);
    }

    public static int askForInteger() {
        System.out.println("Enter count of your students (use only digits 0-9)");
        while (true) { //запускаю цикл - пока пользователь не введет корректные данные, программа его не отпустит
            if (!scanner.hasNextInt()) { //проверяю корректность данных - если введена НЕ цифра, вывожу сообщение об ошибке и цикл с вводом запускается снова
                System.out.println("Use only numbers 0-9.");//вывод сообщения с ошибкой
                scanner.next(); //пренебрегаю некорректным символом и перехожу к проверке следующего ввода
            } else { //если пользователь все заполнил правильно, возвращаю int-значение
                return scanner.nextInt();  //возврат корректного целочисленного значения для сравнения в main
            }
        }
    }

    public static ArrayList<ArrayList<String>> fillAttendSheet(final int count) { // метод заполнения таблицы
        int localCount = count + 1; //мы получаем число студентов
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        while (localCount > 0) { //создаем двоичный лист по высоте измеримый к-ву студентов + 1 (плюс один делается в мейне)
            arrayLists.add(new ArrayList<>());
            localCount--;
        }
        return arrayLists;
    }

    public static void fillArrayByNames(ArrayList<ArrayList<String>> attendSheet) throws IOException { //извините, тут у меня не получилось через Scanner - приходилось городить костыли из-за того, что сканнер откуда-то брал пустую строку "", поэтому я использовал более знакомый мне BufferedReader
        int arrLength = attendSheet.size();
        int count = 1;
        System.out.println("Enter the names of your students");
        String name;
        while (count < arrLength) { //пока мы не введем количество студентов, равное высоте массива, от пользователя не отстанем
            name = bfr.readLine(); //считываем строку
            if (name == null || name.length() < 3 || name.trim().length() < 3) { //проверяем строку на нуль и на длину. Имя студентов из цифр пока считаем допустимым (возможно, преподаватель захочет в двоичном коде записывать имена)
                System.out.println("Incorrect name, try again");
            } else {
                attendSheet.get(count).add(name); //если имя не пустое и состоит хотя бы из 3 символов, добавляем его в массив и оповещаем преподавателя
                count++;
                System.out.println("Student " + name + " successfully added. " + (arrLength - count) + " students left to add");
            }
        }
    }

    public static ArrayList<ArrayList<String>> fillDateLesson(ArrayList<ArrayList<String>> attendSheet) throws IOException { //в этом методе наполняем таблицу датами уроков
        String readDate;
        print("Enter the date of lesson. Use day-month type: 15/07.");
        boolean flag = true;
        while (flag) {
            readDate = bfr.readLine();
            if (readDate == null || readDate.length() < 1 || readDate.trim().length() < 1) { //проверяем строку на нуль и на длину
                print("Incorrect date, try again");
            } else
                attendSheet.get(0).add(readDate); //если имя не пустое и состоит хотя бы из 3 символов, добавляем его в массив и оповещаем преподавателя
            print("Date " + readDate + " successfully added.");
            flag = false;
        }
        return attendSheet;
    }

    public static void askForNoticeStudent(ArrayList<ArrayList<String>> attendSheet) { //здесь мы просим преподавателя заполнить посещаемость
        print("Enter the students number to notice it. Enter exit to exit. Enter delete and students number to delete if (example: delete 1)");
        printStudentsWithNumbers(attendSheet);
        while (true) { //здесь считываем в консоль студентов для заполнения (их коды)
            try {
                String readStudentNumber = bfr.readLine().toLowerCase();
                if (readStudentNumber.equals("exit")) {
                    break;
                } else {
                    if (readStudentNumber.contains("delete")) {
                        removeStudent(readStudentNumber, attendSheet);
                    } else {
                        int notice = Integer.parseInt(readStudentNumber);
                        if (notice > attendSheet.size() - 1) {
                            print("Student not exists");
                        } else {
                            attendSheet.get(notice).add("+");
                            print("Student is noticed successfully: " + attendSheet.get(notice).get(0));
                        }
                    }
                }
            } catch (IOException | NumberFormatException exc) {
                System.out.println("Use only integers 0-9");
            }
        }
        fillNoneStudents(attendSheet);
    }

    private static void removeStudent(final String readStudentNumber, ArrayList<ArrayList<String>> attendSheet){
        String[] delete = readStudentNumber.trim().split("\\s+");
        int numberToDelete = Integer.parseInt(delete[1]);
        attendSheet.remove(numberToDelete);
        print("Successfully removed: "  + attendSheet.get(numberToDelete).get(0));
        print("Enter the students number to notice it. Enter exit to exit. Enter delete and students number to delete if (example: delete 1)");
        printStudentsWithNumbers(attendSheet);
    }

    private static void printStudentsWithNumbers(ArrayList<ArrayList<String>> attendSheet){
        int arrHeight = attendSheet.size();
        for (int i = 1; i < arrHeight; i++) { //здесь выводим имена и код имени в консоль
            print(i + " - " + attendSheet.get(i).get(0));
        }
    }

    private static void fillNoneStudents(ArrayList<ArrayList<String>> attendSheet) { //здесь мы помечаем минусами всех студентов, которые не помечены плюсами - так удобнее контролить их
        int max = attendSheet.get(0).size(); //мы получаем длину первого массива - он всегда будет самый большой
        for (ArrayList<String> arrayList : attendSheet) {
            if (arrayList.size() < max) {
                while (arrayList.size() < max) { //и тупо заполняем остальные массивы, если они короче первого минусами
                    arrayList.add("-");
                }
            }
        }
    }

    public static void bringBeauty(ArrayList<ArrayList<String>> attendSheet) { //здесь делаем таблицу немного красивее - добавляем отступы
        int max = Integer.MIN_VALUE;
        for (ArrayList<String> arrayList : attendSheet) {  //здесь мы ищем самое длинное имя - оно надо, чтобы правильно настроить отступы
            if (max < arrayList.get(0).length()) {
                max = arrayList.get(0).length();
            }
        }
        StringBuilder stringBuilder;
        for (int i = 0; i < attendSheet.get(0).size(); i++) { //здесь идем по каждой ячейке массива и если она слишком короткая, наращиваем ей длину
            for (int j = 0; j < attendSheet.size(); j++) {
                if (attendSheet.get(j).get(i) != null && max > attendSheet.get(j).get(i).length()) {
                    stringBuilder = new StringBuilder(attendSheet.get(j).get(i));
                    while (stringBuilder.length() != max) {
                        stringBuilder.append(" ");
                    }
                    attendSheet.get(j).set(i, stringBuilder.toString());
                }
            }
            max = 5; //меньше 5 отступов нельзя
        }
    }

    public static void printStudents(ArrayList<ArrayList<String>> attendSheet) { //тут печатаем студентов в консоль
        for (ArrayList<String> strings : attendSheet) {
            for (String s : strings) {
                if (s != null) {
                    System.out.print(s + " ");
                }
            }
            System.out.println();
        }
    }

    public static boolean wishToContinue() throws IOException { //здесь спрашиваем, хочет ли преподаватель дальше заполнять таблицу
        System.out.println("Want to continue? Press y to continue, another key to exit the program");
        String s;
        s = bfr.readLine();
        if (s != null && s.equals("y")) {
            System.out.println("Continue");
            return true;
        } else {
            System.out.println("Bye!");
            return false;
        }
    }
}
