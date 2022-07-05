package services;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;

import java.util.List;

public interface IFacilityService {
    List<Facility> display();

    void addNewVilla(Villa villa);

    void addNewHouse(House house);

    void addNewRoom(Room room);

    Facility edit(int id);

    Facility delete(int id);
}
