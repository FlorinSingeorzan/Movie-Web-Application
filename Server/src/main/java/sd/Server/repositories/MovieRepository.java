package sd.Server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sd.Server.entities.Movie;

import java.util.List;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    List<Movie> findAll();
    Movie findByTitle(String title);
    List<Movie> findAllByRate(int rate);

    Movie findById(int id);
}

