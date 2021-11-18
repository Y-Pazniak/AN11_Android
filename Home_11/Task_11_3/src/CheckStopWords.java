public class CheckStopWords implements Runnable {
    private String[] blackList;
    private String[] text;


    public CheckStopWords(final String[] blackList, final String[] text) {
        this.blackList = blackList;
        this.text = text;
    }

    @Override
    public void run() {
        checkForStopWords(blackList, text);
    }

    private static void checkForStopWords(final String[] blackList, final String[] text) {
        for (String blackWord: blackList) {
            for (String line: text) {
                String[] words = line.trim().split("[.!?,:;«»\"\\s+]");
                for (String word: words) {
                    if (blackWord.equalsIgnoreCase(word)){
                        System.out.println("Wrong word: \"" + blackWord + "\" at line: \"" + line + "\"");
                    }
                }
            }
        }
    }
}
