import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"как", "козодой", "кот", "кабак", "кулебяка", "кок", "козел", "мадам", "расстегай", "шалаш", "шабаш", "черт"};
        FutureTask<Boolean>[] futureTasks = fillFutureTask(words);
        printResult(futureTasks, words);
    }

    private static FutureTask<Boolean>[] fillFutureTask(final String[] words) {
        FutureTask<Boolean>[] futureTasks = new FutureTask[words.length];
        for (int i = 0; i < words.length; i++) {
            PalindromeFinder palindromeFinder = new PalindromeFinder(words[i]);
            FutureTask<Boolean> futureTask = new FutureTask<>(palindromeFinder);
            futureTasks[i] = futureTask;
            new Thread(futureTask).start();
        }
        return futureTasks;
    }

    private static void printResult(final FutureTask<Boolean>[] futureTasks, final String[] words) {
        boolean needNext = true;

        while (needNext) {
            int count = 0;
            for (int i = 0; i < futureTasks.length; i++) {
                FutureTask<Boolean> futureTask = futureTasks[i];
                if (futureTask != null) {
                    if (futureTask.isDone()) {
                        try {
                            System.out.println(futureTask.get() ? "is palindrome: " + words[i] : "is not palindrome: " + words[i]);
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                        futureTasks[i] = null;
                    }
                } else {
                    count++;
                }
                if (count == futureTasks.length) {
                    needNext = false;
                }
            }
        }
    }
}
