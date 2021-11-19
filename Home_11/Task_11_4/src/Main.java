import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"как", "козодой", "кот", "кабак", "кулебяка", "кок", "козел", "мадам", "расстегай", "шалаш", "шабаш", "черт"};
        FutureTask<String>[] futureTasks = fillFutureTask(words);
        printResult(futureTasks);
    }

    private static FutureTask<String>[] fillFutureTask(String[] words) {
        FutureTask<String>[] futureTasks = new FutureTask[words.length];
        for (int i = 0; i < words.length; i++) {
            PalindromeFinder palindromeFinder = new PalindromeFinder(words[i]);
            FutureTask<String> futureTask = new FutureTask<>(palindromeFinder);
            futureTasks[i] = futureTask;
            new Thread(futureTask).start();
        }
        return futureTasks;
    }

    private static void printResult(FutureTask<String>[] futureTasks) {
        boolean needNext = true;

        while (needNext) {
            int count = 0;
            for (int i = 0; i < futureTasks.length; i++) {
                FutureTask<String> futureTask = futureTasks[i];
                if (futureTask != null) {
                    if (futureTask.isDone()) {
                        try {
                            System.out.println(futureTask.get());
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
