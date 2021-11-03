public class Main { //2) Заменить все вхождения символа стоящего в позиции (3) на сивол стоящий в позиции 0
    public static void main(String[] args) {
        String text = "Летят по небу шарики, летят они, летят.";
        System.out.println(text.replace(text.charAt(3), text.charAt(0)));
    }
}
