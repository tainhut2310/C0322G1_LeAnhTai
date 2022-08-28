package service.impl;

import model.AttachFacility;
import repository.IAttachFacilityRepository;
import repository.impl.AttachFacilityRepository;
import service.IAttachFacilityService;

import java.sql.SQLException;
import java.util.List;

public class AttachFacilityService implements IAttachFacilityService {
    private IAttachFacilityRepository attachFacilityRepository = new AttachFacilityRepository();
    @Override
    public List<AttachFacility> selectAll() throws SQLException {
        return attachFacilityRepository.selectAll();
    }
}
