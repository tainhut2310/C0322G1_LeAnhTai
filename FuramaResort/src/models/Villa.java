package models;

public class Villa extends Facility {
    private String typeVilla;
    private double areaPool;
    private int floors;

    public Villa() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                super.getIdFacility(),
                super.getNameService(),
                super.getUsableArea(),
                super.getRentalCosts(),
                super.getMaximumNumberOfPeople(),
                super.getRentalType(),
                this.typeVilla,
                this.areaPool,
                this.floors + "\n");
    }

    public Villa(String idFacility,
                 String nameService,
                 double usableArea,
                 double rentalCosts,
                 int maximumNumberOfPeople,
                 String rentalType,
                 String typeVilla,
                 double areaPool,
                 int floors) {
        super(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.typeVilla = typeVilla;
        this.areaPool = areaPool;
        this.floors = floors;
    }

    public String getTypeVilla() {
        return typeVilla;
    }

    public void setTypeVilla(String typeVilla) {
        this.typeVilla = typeVilla;
    }

    public double getAeaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                "typeVilla='" + typeVilla + '\'' +
                ", areaPool=" + areaPool +
                ", floors=" + floors +
                '}';
    }
}
