import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Vasya: " + check("Vasya", "qwERty_11", "qwERty_11"));
        System.out.println("NaTySiK_2010: " + check("NaTySiK_2010", "nata666", "nata666"));
        System.out.println("KOSTYAN: " + check("KOSTYAN", "123", "321"));
        System.out.println("Super_Hecker: " + check("Super_Hecker", "jsfjp)#(&#()$&", "jsfjp)#(&#()$&"));
        System.out.println("Сергей: " + check("Сергей", "asd", "asd"));
        System.out.println("Grzegorz: " + check("Grzegorz_Brzęczyszczykiewicz", "111", "111"));
        System.out.println("NaGGiBaTOR_777: " + check("NaGGiBaTOR_777", "we_will_we_will_rock_you", "we_will_we_will_rock_you"));
    }

    public static boolean check(final String login, final String password, final String confirmPassword) {
        boolean isOk = true;
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException("Too long login, use less 20 symbols.");
            }

            if (password.length() >= 20) {
                throw new WrongPasswordException("Too long password, use less 20 symbols.");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password and confirm password are not equals.");
            }

            if (!checkCorrectSymbols(login)) {
                throw new WrongLoginException("Wrong login. Use only A-Z(a-z) letters, 0-9 integers and underscore \"_\".");
            }

            if (!checkCorrectSymbols(password)) {
                throw new WrongPasswordException("Wrong password. Use only A-Z(a-z) letters, 0-9 integers and underscore \"_\".");
            }
        } catch (WrongLoginException | WrongPasswordException exception) {
            isOk = false;
            exception.printStackTrace();
        }
        return isOk;
    }

    private static boolean checkCorrectSymbols(final String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!checkIntegers(c)
                    && !checkLowerCaseSymbols(c)
                    && !checkUpperCaseSymbols(c)
                    && !checkUnderscore(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIntegers(final char c){
        return ((c > 47) && (c < 58));
    }

    private static boolean checkLowerCaseSymbols(final char c){
        return ((c > 96) && (c < 123));
    }

    private static boolean checkUpperCaseSymbols(final char c){
        return ((c > 64) && (c < 91));
    }

    private static boolean checkUnderscore(final char c){
        return c == 95;
    }
}
