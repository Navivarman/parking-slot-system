import java.time.Duration;
import java.time.Instant;
public class HourlyPricingStrategy implements PricingStrategy {
    public double calculateFee(Vehicle vehicle, Instant entryTime, Instant exitTime) {
        long hours = Duration.between(entryTime, exitTime).toHours();
        if(hours == 0){
            hours = 1;
        }

        switch (vehicle.getType()) {
            case MOTORBIKE: return hours * 10.0;
            case CAR:       return hours * 20.0;
            case VAN:       return hours * 30.0;
            case TRUCK:     return hours * 50.0;
            default:        return hours * 20.0;
        }
    }
}
