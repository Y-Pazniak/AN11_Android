public abstract class LandTransport extends Transport{
    private final int wheelsCount;
    private int fuelConsumption;

    public LandTransport(int horsePower, int maxSpeed, int massVehicle, String brand, int wheelsCount, int fuelConsumption) {
        super(horsePower, maxSpeed, massVehicle, brand);
        this.wheelsCount = wheelsCount;
        this.fuelConsumption = fuelConsumption;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
