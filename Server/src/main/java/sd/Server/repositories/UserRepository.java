package sd.Server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sd.Server.entities.UserApi;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200/")
public interface UserRepository extends JpaRepository<UserApi,Integer> {

    List<UserApi> findAll();

    UserApi findById(int id);
    UserApi findByName(String name);

}
