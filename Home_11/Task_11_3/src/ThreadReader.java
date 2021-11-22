import java.util.List;

public class ThreadReader implements Runnable {
    private final int start;
    private final int finish;
    private final String[] blackList;
    private final String[] text;
    private List<String> synchronizedList;

    public ThreadReader(final int start, final int finish, final String[] blackList, final String[] text, final List<String> synchronizedList) {
        this.start = start;
        this.finish = finish;
        this.blackList = blackList;
        this.text = text;
        this.synchronizedList = synchronizedList;
    }

    @Override
    public void run() {
        checkForStopWords(blackList, text, start, finish, synchronizedList);
    }

    private void checkForStopWords(final String[] blackList, final String[] text, final int start, final int finish, List<String> synchronizedList) {
        //System.out.println(Thread.currentThread().getName() + ": " + "start: " + start + " finish: " + finish);
        for (String blackWord : blackList) {
            for (int i = start; i < finish; i++) {
                String[] words = text[i].trim().split("[.!?,:;«»\"\\s+]");
                for (String word : words) {
                    if (blackWord.equalsIgnoreCase(word)) {
                        System.out.println("Wrong word: \"" + blackWord + "\" at line: \"" + text[i] + "\"");
                        synchronizedList.add(text[i]);
                        Main.isTextOk = false;
                    }
                }
            }
        }

    }
}
