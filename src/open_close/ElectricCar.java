package open_close;

public class ElectricCar extends Vehicle {
    private String type;
    private String batery;

    public ElectricCar(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getBatery(){
        return batery;
    }
}
