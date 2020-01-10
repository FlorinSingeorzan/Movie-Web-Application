package sd.Server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    import sd.Server.entities.Role;
import sd.Server.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


        public List<Role> findAll() {

        return roleRepository.findAll();
    }

    public boolean delete(int id){
        roleRepository.deleteById(id);
        return true;
    }

        public int create(Role role){
            Role toReturn= roleRepository.save(role);
        return toReturn.getId();
    }

        public int update(Role role) {
            Role toReturn= roleRepository.save(role);
        return toReturn.getId();
    }


}
