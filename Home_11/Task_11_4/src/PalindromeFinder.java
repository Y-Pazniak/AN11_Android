import java.util.concurrent.Callable;

public class PalindromeFinder implements Callable<String> {
    private final String wordToCheck;

    public PalindromeFinder(final String wordToCheck) {
        this.wordToCheck = wordToCheck;
    }

    @Override
    public String call() throws Exception {
        return isPalindrome();
    }

    private String isPalindrome() {
        StringBuilder sb = new StringBuilder(wordToCheck);
        String reverseWord = sb.reverse().toString();
        try {
            Thread.sleep(500 + (int) (Math.random() * 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return wordToCheck.equals(reverseWord) ? wordToCheck + " - is palindrome" : wordToCheck + " - not palindrome";
    }
}
