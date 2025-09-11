import java.util.Optional;

public interface SpotAllocationStrategy {
    Optional<ParkingSpot> findSpot(ParkingLot lot,Vehicle vehicle);

}
