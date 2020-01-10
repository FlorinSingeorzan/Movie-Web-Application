package sd.Server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sd.Server.entities.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
     List<Role> findAll();

     List<Role> findByIdMovie(int idMovie);
}
