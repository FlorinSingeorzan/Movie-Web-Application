package sd.Server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sd.Server.entities.Feedback;

import java.util.List;

@RepositoryRestResource
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    List<Feedback> findAll();

    List<Feedback> findByMovieId(int movieId);
    List<Feedback> findByUserId(int userId);
    Feedback findByUserIdAndMovieId(int userId, int movieId);

}
