package services.impl;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import repositoy.IFacilityRepository;
import repositoy.impl.FacilityRepositoryImpl;
import services.IFacilityService;

import java.util.List;

public class FacilityServiceImpl implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepositoryImpl();


    @Override
    public List<Facility> display() {
        return facilityRepository.display();
    }

    @Override
    public void addNewVilla(Villa villa) {
        facilityRepository.addNewVilla(villa);
    }

    @Override
    public void addNewHouse(House house) {
        facilityRepository.addNewHouse(house);
    }

    @Override
    public void addNewRoom(Room room) {
        facilityRepository.addNewRoom(room);
    }

    @Override
    public Facility edit(int id) {
        return facilityRepository.delete(id);
    }

    @Override
    public Facility delete(int id) {
        return null;
    }
}
