package models;

public class House extends Facility {
    private String standardRoom;
    private String descriptionOtherConvenience;
    private int numberOfFloors;

    public House() {
    }

    public House(int idFacility,
                 String nameFacility,
                 double usableArea,
                 double rentalCosts,
                 int maximumNumberOfPeople,
                 String rentalType,
                 String standardRoom,
                 String descriptionOtherConvenience,
                 int numberOfFloors) {
        super(idFacility, nameFacility, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
