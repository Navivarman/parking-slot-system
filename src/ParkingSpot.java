public class ParkingSpot {
    private final String id;
    private final int levelNumber;
    private final String spotNumber;
    private final SpotType type;
    private boolean occupied;
    private String ticketId;

    public ParkingSpot(String id,int levelNumber,String spotNumber,SpotType type){
        this.id = id;
        this.levelNumber = levelNumber;
        this.spotNumber = spotNumber;
        this.type = type;
        this.occupied = false;
        this.ticketId = null;
    }

    public boolean isOccupied() { return occupied; }

    public boolean occupy(String ticketId){
        if(!occupied){
            this.occupied = true;
            this.ticketId = ticketId;
            return true;
        }
        return false;
    }

    public void free(){
        this.occupied = false;
        this.ticketId = null;
    }

    public SpotType getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
