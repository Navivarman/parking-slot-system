import java.util.*;
public class Level {
    private final int levelNumber;
    private final Map<String,ParkingSpot> spots;

    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
        this.spots = new HashMap<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.put(spot.getId(), spot);
    }

    public List<ParkingSpot> getAvailableSpotsByType(SpotType type) {
        List<ParkingSpot> available = new ArrayList<>();
        for (ParkingSpot spot : spots.values()) {
            if (!spot.isOccupied() && spot.getType() == type) {
                available.add(spot);
            }
        }
        return available;
    }

    public boolean reserveSpot(String spotId, String ticketId){
        ParkingSpot spot = spots.get(spotId);
        if(spot != null){
            return spot.occupy(ticketId);
        }
        return false;
    }

    public void freeSpot(String spotId){
        ParkingSpot spot = spots.get(spotId);
        if(spot != null){
            spot.free();
        }
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public Map<String,ParkingSpot> getAllSpots() {
        return spots;
    }
}
