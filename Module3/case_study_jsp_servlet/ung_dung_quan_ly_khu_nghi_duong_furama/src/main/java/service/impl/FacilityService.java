package service.impl;

import model.Facility;
import model.validate.Validate;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public Map<String, String> insert(Facility facility) throws SQLException {
        Map<String, String> mapErrors = new HashMap<>();
        if (!facility.getName().isEmpty()) {
            if (!Validate.checkNameFacility(facility.getName())) {
                mapErrors.put("name", "*Nhập tên sai định dạng, các kí tự đầu tiên của mỗi từ phải viết hoa");
            }
        } else {
            mapErrors.put("name", "*Vui lòng nhập tên");
        }
        String amount = String.valueOf(facility.getMaxPeople());
            if (!Validate.checkPositive(amount)) {
                mapErrors.put("amount", "*Nhập số lượng sai định dạng, số lượng phải là số nguyên dương");
            }
        String numberOflFoors = String.valueOf(facility.getNumberOfFloors());
        if (!Validate.checkPositive(numberOflFoors)) {
            mapErrors.put("numberOfFloors", "*Nhập số lượng sai định dạng, số tầng phải là số nguyên dương");
        }
        if (mapErrors.size()==0) {
            facilityRepository.insert(facility);
        }
        return mapErrors;
    }

    @Override
    public Facility selectById(int id) throws SQLException {
        return facilityRepository.selectById(id);
    }

    @Override
    public List<Facility> selectByName(String nameSearch) throws SQLException {
        return facilityRepository.selectByName(nameSearch);
    }

    @Override
    public List<Facility> selectAll() throws SQLException {
        return facilityRepository.selectAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return facilityRepository.delete(id);
    }

    @Override
    public boolean update(Facility facility) throws SQLException {
        return facilityRepository.update(facility);
    }
}
