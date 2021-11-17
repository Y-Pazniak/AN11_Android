import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Util.print("Hello, Maksim! Virtual attendance log v.0.9 greetings you");
        ArrayList<ArrayList<String>> attendSheet = Util.fillAttendSheet(Util.askForInteger()); //создаем новый лист с листами
        attendSheet.get(0).add("Stud/Date"); //заполняем первую ячейку первого массива
        Util.fillArrayByNames(attendSheet); //здесь запрашиваем имена студентов (только 1 раз, поэтому вне цикла)
        go(attendSheet); //начинаем работу программы
    }

    private static void go(ArrayList<ArrayList<String>> attendSheet) throws IOException { //этот метод содержит всю логику
        Util.fillDateLesson(attendSheet); //запрашиваем дату
        Util.askForNoticeStudent(attendSheet); //просим отметить студентов
        Util.bringBeauty(attendSheet); //наводим красоту в таблице (добавляем отступы)
        Util.printStudents(attendSheet); //выводим содержимое таблицы
        if (Util.wishToContinue()) { //если Максим хочет еще заполнять таблицу, то вызываем метод go повторно
            go(attendSheet);
        }
    }
}
