import java.time.Instant;
import java.util.*;

public class ParkingService {
    private final ParkingLot lot;
    private final SpotAllocationStrategy allocationStrategy;
    private final PricingStrategy pricingStrategy;
    private final Map<String,Ticket> activeTickets;

    public ParkingService(ParkingLot lot, SpotAllocationStrategy allocationStrategy, PricingStrategy pricingStrategy) {
        this.lot = lot;
        this.allocationStrategy = allocationStrategy;
        this.pricingStrategy = pricingStrategy;
        this.activeTickets = new HashMap<>();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> spotOpt = allocationStrategy.findSpot(lot, vehicle);

        if (!spotOpt.isPresent()) {
            System.out.println("❌ No spot available for " + vehicle.getType());
            return null;
        }
        ParkingSpot spot = spotOpt.get();

        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle.getPlate(),vehicle.getType(),spot.getId(),Instant.now());

        lot.reserveSpot(spot.getId(),spot.getLevelNumber(),ticketId);

        activeTickets.put(ticketId,ticket);

        System.out.println("✅ Vehicle " + vehicle.getPlate() +
                " parked at Spot " + spot.getId() +
                " [Level " + spot.getLevelNumber() + "]");
        return ticket;
    }

    public void unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket != null){
            System.out.println("❌ Invalid Ticket ID");
            return;
        }

        Instant exitTime = Instant.now();
        double amount = pricingStrategy.calculateFee( new Vehicle(ticket.getPlate(),ticket.getType()),ticket.getEntryTime(),exitTime);

        ticket.close(exitTime,amount);

        lot.freeSpot(ticket.getSpotId(),getLevelNumberFromSpot(ticket.getSpotId()));
        activeTickets.remove(ticketId);

        System.out.println("💰 Vehicle " + ticket.getPlate() +
                           " exited. Fee = ₹" + amount);
    }

    private  int getLevelNumberFromSpot(String spotId) {
        String[] parts = spotId.split("_");
        return Integer.parseInt(parts[0].substring(1));
    }
}
