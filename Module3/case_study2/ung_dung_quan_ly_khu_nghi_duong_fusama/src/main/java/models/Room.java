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

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                super.getIdFacility(),
                super.getNameService(),
                super.getUsableArea(),
                super.getRentalCosts(),
                super.getMaximumNumberOfPeople(),
                super.getRentalType(),
                this.serviceFree + "\n");
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
