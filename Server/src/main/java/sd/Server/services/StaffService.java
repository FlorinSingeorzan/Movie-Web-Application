package sd.Server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.Server.entities.Staff;
import sd.Server.repositories.StaffRepository;

import java.util.List;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    public List<Staff> findAll() {

        return staffRepository.findAll();
    }

    public boolean delete(int id){
        staffRepository.deleteById(id);
        return true;
    }

    public int create(Staff staff){
        Staff toReturn= staffRepository.save(staff);
        return toReturn.getId();
    }

    public int update(Staff staff) {
        Staff toReturn= staffRepository.save(staff);
        return toReturn.getId();
    }

    public Staff findByName(String name) {
        return staffRepository.findByName(name);
    }
    public Staff findById(int id) {
        return staffRepository.findById(id);
    }
}
