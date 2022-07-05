package models;

public class Room extends Facility {
    private String facilityFree;

    public Room() {
    }

    public Room(int idFacility,
                String nameService,
                double usableArea,
                double rentalCosts,
                int maximumNumberOfPeople,
                String rentalType,
                String facilityFree) {
        super(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.facilityFree = facilityFree;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }
}
