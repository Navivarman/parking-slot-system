import java.util.*;

public class ParkingLot {
    private final String id;
    private final String name;
    private final Map<Integer,Level> levels;

    public ParkingLot(String id, String name) {
        this.id = id;
        this.name = name;
        this.levels = new HashMap<>();
    }

    public void addLevel(Level level) {
        levels.put(level.getLevelNumber(), level);
    }

    public Optional<ParkingSpot> findAvailableSpot(SpotType type){
        for(Level level : levels.values()){
            List<ParkingSpot> available = level.getAvailableSpotsByType(type);
            if(!available.isEmpty()){
                return Optional.of(available.get(0));
            }
        }
        return Optional.empty();
    }

    public  boolean reserveSpot(String spotId, int levelNumber, String ticketId){
        Level level = levels.get(levelNumber);
        if(level != null){
            return level.reserveSpot(spotId,ticketId);
        }
        return false;
    }

    public void freeSpot(String spotId, int levelNumber){
        Level level = levels.get(levelNumber);
        if(level != null){
            level.freeSpot(spotId);
        }
    }

    public void printStatus(){
        System.out.println("Parking Lot: " + name);
        for(Level level : levels.values()){
            System.out.println("Level: " + level.getLevelNumber() + " ->" + level.getAllSpots().size() + "spots");
        }
    }

    public String getId(){ return id; }
    public String getName(){ return name;}
    public Map<Integer,Level> getLevels(){ return levels; }
}
