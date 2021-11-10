import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        try {
            exceptions();
        } catch (FileNotFoundException | NullPointerException exception) { //мы перехватили согласно условиям задачи 2 исключения
            // одно (непроверяемое) не перехватывали (проигнорировали), другое (проверяемое) перекинули выше по стеку
            exception.printStackTrace();
        }
    }

    public static void exceptions() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
        System.out.println("tadam");
    }
}
