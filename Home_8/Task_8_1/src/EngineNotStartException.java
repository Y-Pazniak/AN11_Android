public class EngineNotStartException extends Exception{ //сюда больше подходит какой-нибудь IllegalArgumentException, но он uncheckded
    //а я хотел, чтобы валидатор предупреждал о моем исключении и заставлял его обратаывать, поэтому выбрал просто Exception

    public EngineNotStartException() {
    }

    public EngineNotStartException(final String s) {
        super(s);
    }

    public void callTowTruck(){
        System.out.println("Your tow track is on the way.");
    }
}
