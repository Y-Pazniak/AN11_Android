import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"как", "козодой", "кот", "кабак", "кулебяка", "кок", "козел", "мадам", "расстегай", "шалаш", "шабаш", "черт"};
        Future<Boolean>[] futureTasks = fillFutureTask(words);
        printResult(futureTasks, words);
    }

    private static Future<Boolean>[] fillFutureTask(final String[] words) {
        Future<Boolean>[] futureTasks = new Future[words.length];
        ExecutorService service = Executors.newFixedThreadPool(8);
        for (int i = 0; i < words.length; i++) {
            Future result = service.submit(new PalindromeFinder(words[i]));
            futureTasks[i] = result;
        }
        service.shutdown();
        return futureTasks;
    }

    private static void printResult(final Future<Boolean>[] futureTasks, final String[] words) {
        boolean needNext = true;

        while (needNext) {
            int count = 0;
            for (int i = 0; i < futureTasks.length; i++) {
                Future<Boolean> futureTask = futureTasks[i];
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
