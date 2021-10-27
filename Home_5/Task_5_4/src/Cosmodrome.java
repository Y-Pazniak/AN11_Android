public class Cosmodrome {
    public void start(IStart start) throws InterruptedException {
        if (!start.checkBeforeStart()){
            System.out.println(start.getClass().toString() + " - предстартовая проверка провалена");
        } else {
            start.enginesStart();
            for (int i = 10; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(100);
            }
            start.start();
        }
    }
}
