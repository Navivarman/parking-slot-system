public class Vehicle {
    private final String plate;
    private final VehicleType type;

    public Vehicle(String plate, VehicleType type) {
        this.plate = plate;
        this.type = type;
    }

    public String getPlate(){
        return plate;
    }

    public VehicleType getType(){
        return type;
    }

    public String toString(){
        return "Vehicle{" +
                "plate='" + plate + '\'' +
                ", type=" + type +
                '}';
    }
}
