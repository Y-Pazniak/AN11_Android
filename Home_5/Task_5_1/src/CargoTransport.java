public class CargoTransport extends LandTransport { //реализация грузового транспорта - самосвалов, фур, грузовиков и прочего
    private int payloadCapacity;

    public CargoTransport(int horsePower, int maxSpeed, int massVehicle, String brand, int wheelsCount, int fuelConsumption, int payloadCapacity) {
        super(horsePower, maxSpeed, massVehicle, brand, wheelsCount, fuelConsumption);
        this.payloadCapacity = payloadCapacity;
    }

    public int getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(int payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    public String description() {
        return String.format("""
                        CargoTransport horse power is %d,
                        max speed is %d,
                        mass vehicle is %d,
                        brand is %s,
                        wheels count is %d,
                        fuel consumption is %s,
                        max load capacity is %d,
                        kW power is %.2f.""",
                getHorsePower(), getMaxSpeed(), getMassVehicle(), getBrand(), getWheelsCount(),
                getFuelConsumption(), getPayloadCapacity(), countKW());
    }

    private double countKW() {
        return getHorsePower() * 0.74;
    }

    public void loadTheTruck(int weightToLoad) {
        System.out.println(weightToLoad > getPayloadCapacity() ? "Вам нужен грузовик побольше." : "Грузовик загружен.");
        System.out.println("*****");
    }
}
