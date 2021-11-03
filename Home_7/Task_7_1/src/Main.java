public class Main {
    public static void main(String[] args) { //Вырезать подстроку из строки начиная с первого вхождения символа(А) до, последнего вхождения сивола(B).
        String text = "Каспар Шлих, куря табак, нес под мышкой двух собак.";
        String substring = text.substring(text.indexOf('а'), text.lastIndexOf('в'));
        System.out.println(substring);
    }
}