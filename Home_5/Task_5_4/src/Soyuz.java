public class Soyuz implements IStart{
    @Override
    public boolean checkBeforeStart() {
        return (int)(Math.random() * 10) > 4;
    }

    @Override
    public void enginesStart() {
        System.out.println("Soyuz engines turns on.");
    }

    @Override
    public void start() {
        System.out.println("Soyuz starts successfully.");
    }
}
