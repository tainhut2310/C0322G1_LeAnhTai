package models;

public class Room extends Facility {
    private String serviceFree;

    public Room() {
    }

    public Room(String idFacility,
                String nameService,
                double usableArea,
                double rentalCosts,
                int maximumNumberOfPeople,
                String rentalType,
                String serviceFree) {
        super(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public String toString() {
        return "Room{" + super.toString() +
                "serviceFree='" + serviceFree + '\'' +
                '}';
    }
}
