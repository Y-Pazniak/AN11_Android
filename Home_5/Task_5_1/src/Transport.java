public abstract class Transport { //этот класс я сделал абстрактным, потому что не вижу смысла делать объекты типа "транспорт" (слишком общее понятие)
    //здесь и далее помечал переменные final, если с моей субъективной точки зрения они не могут меняться: масса ТС, скорость и лошадиные силы поменяться могут, а марка - нет
    private int horsePower;
    private int maxSpeed;
    private int massVehicle;
    private final String brand;

    public Transport(int horsePower, int maxSpeed, int massVehicle, String brand) {
        this.horsePower = horsePower;
        this.maxSpeed = maxSpeed;
        this.massVehicle = massVehicle;
        this.brand = brand;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setMassVehicle(int massVehicle) {
        this.massVehicle = massVehicle;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMassVehicle() {
        return massVehicle;
    }

    public String getBrand() {
        return brand;
    }
}
