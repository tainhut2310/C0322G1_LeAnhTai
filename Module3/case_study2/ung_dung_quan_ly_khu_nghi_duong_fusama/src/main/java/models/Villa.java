package models;

public class Villa extends Facility {
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double areaPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(int idFacility,
                 String nameFacility,
                 int usableArea,
                 double rentalCosts,
                 int maxPeople,
                 String rentalType,
                 String standardRoom,
                 String descriptionOtherConvenience,
                 double areaPool,
                 int numberOfFloors) {
        super(idFacility,nameFacility, usableArea, rentalCosts, maxPeople, rentalType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
