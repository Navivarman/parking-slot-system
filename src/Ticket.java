import java.time.Instant;
public class Ticket {
    private final String ticketId;
    private final String plate;
    private final VehicleType type;
    private final String spotId;
    private final Instant entryTime;
    private Instant exitTime;
    private double amount;
    private boolean paid;

    public Ticket(String ticketId, String plate, VehicleType type, String spotId, Instant entryTime) {
        this.ticketId = ticketId;
        this.plate = plate;
        this.type = type;
        this.spotId = spotId;
        this.entryTime = entryTime;
        this.paid = false;
    }

    public void close(Instant exitTime,double amount) {
        this.exitTime = exitTime;
        this.amount = amount;
        this.paid = true;
    }

    public String getId() {
        return ticketId;
    }
    public String getPlate() {
        return plate;
    }
    public VehicleType getType() {
        return type;
    }
    public String getSpotId() {
        return spotId;
    }
    public Instant getEntryTime() {
        return entryTime;
    }
    public Instant getExitTime() {
        return exitTime;
    }
    public double getAmount() {
        return amount;
    }
    public boolean isPaid() {
        return paid;
    }
}
