package open_close;

public class Car extends Vehicle{
    private String type;

    public Car(String type){this.type=type;}

    @Override
    public String getType() {
        return type;
    }
}
