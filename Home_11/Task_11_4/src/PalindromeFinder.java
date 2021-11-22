import java.util.concurrent.Callable;

public class PalindromeFinder implements Callable<Boolean> {
    private final String wordToCheck;

    public PalindromeFinder(final String wordToCheck) {
        this.wordToCheck = wordToCheck;
    }

    @Override
    public Boolean call() {
        return isPalindrome();
    }

    private Boolean isPalindrome() {
        StringBuilder sb = new StringBuilder(wordToCheck);
        String reverseWord = sb.reverse().toString();
        try {
            Thread.sleep(500 + (int) (Math.random() * 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return wordToCheck.equals(reverseWord);
    }
}
