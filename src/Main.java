public class Main { public static void main(String[] args) throws InterruptedException {

        ParkingLot lot = new ParkingLot("P1","City Center Parking");

        Level level1 = new Level(1);
        Level level2 = new Level(2);

        level1.addSpot(new ParkingSpot("L1_S1",1,"S1" ,SpotType.REGULAR));
        level1.addSpot(new ParkingSpot("L1_S2", 1, "S2", SpotType.COMPACT));
        level1.addSpot(new ParkingSpot("L1_S3", 1, "S3", SpotType.LARGE));

        level2.addSpot(new ParkingSpot("L2_S1", 2, "S1", SpotType.REGULAR));
        level2.addSpot(new ParkingSpot("L2_S2", 2, "S2", SpotType.HANDICAPPED));
        level2.addSpot(new ParkingSpot("L2_S3", 2, "S3", SpotType.EV));

        lot.addLevel(level1);
        lot.addLevel(level2);

        SpotAllocationStrategy allocationStrategy = new NearestSpotAllocationStrategy();
        PricingStrategy pricingStrategy = new HourlyPricingStrategy();

        ParkingService service = new ParkingService(lot,allocationStrategy,pricingStrategy);

        Vehicle car1 = new Vehicle("KA01AB1234", VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA02XY5678", VehicleType.CAR);


        Ticket ticket1 = service.parkVehicle(car1);
        Ticket ticket2 = service.parkVehicle(car2);

        Thread.sleep(2000);

        service.unparkVehicle(ticket1.getId());
        service.unparkVehicle(ticket2.getId());
    }
}
