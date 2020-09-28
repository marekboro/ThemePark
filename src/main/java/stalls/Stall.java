package stalls;

import behaviours.IReviewed;

public abstract class Stall implements IReviewed {

    private String name;
    private String ownerName;
    private ParkingSpot parkingSpot;
    private int rating;

    public Stall(String name, String ownerName, ParkingSpot parkingSpot) {
        this.name = name;
        this.ownerName = ownerName;
        this.parkingSpot = parkingSpot;
        this.rating = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getRating() {
        return rating;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
