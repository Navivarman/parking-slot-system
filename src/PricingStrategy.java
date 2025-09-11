import java.time.Instant;

public interface PricingStrategy {
    double calculateFee(Vehicle vehicle, Instant entryTime, Instant exitTime);
}
