import java.util.Optional;

public class NearestSpotAllocationStrategy implements SpotAllocationStrategy {

    public Optional<ParkingSpot> findSpot(ParkingLot lot,Vehicle vehicle){
        SpotType requiredType = mapVehicleToSpot(vehicle.getType());

        for(Level level : lot.getLevels().values()){
            for(ParkingSpot spot : level.getAvailableSpotsByType(requiredType)){
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }

    private SpotType mapVehicleToSpot(VehicleType type){
        switch(type){
            case MOTORBIKE: return SpotType.COMPACT;
            case CAR: return SpotType.REGULAR;
            case VAN: return SpotType.LARGE;
            case TRUCK: return SpotType.LARGE;
            default: return SpotType.REGULAR;
        }
    }
}
