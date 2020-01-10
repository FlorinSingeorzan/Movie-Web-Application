package sd.Server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sd.Server.entities.Staff;

import java.util.List;

@RepositoryRestResource
public interface StaffRepository extends JpaRepository<Staff,Integer> {

    List<Staff> findAll();

    Staff findByName(String name);

    Staff findById(int id);


}
