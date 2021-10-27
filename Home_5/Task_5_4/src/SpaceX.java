public class SpaceX implements IStart{
    @Override
    public boolean checkBeforeStart() {
        return (int)(Math.random() * 10) > 5;
    }

    @Override
    public void enginesStart() {
        System.out.println("SpaceX engines turns on.");
    }

    @Override
    public void start() {
        System.out.println("SpaceX starts successfully.");
    }
}
