package sd.Server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.Server.entities.Movie;
import sd.Server.repositories.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MainService mainService;

    @Autowired
    public MovieService(MovieRepository movieRepository, MainService mainService) {
        this.movieRepository = movieRepository;
        this.mainService = mainService;
    }


    public List<Movie> findAll() {

        return movieRepository.findAll();
    }

    public boolean delete(int id){
        movieRepository.deleteById(id);
        return true;
    }

    public int create(Movie movie){
        if(movie!=null && !movie.getTitle().equals(""))
        mainService.sendMail(movie.getTitle());
        Movie toReturn= movieRepository.save(movie);

        return toReturn.getId();
    }



    public int update(Movie movie) {
        Movie toReturn= movieRepository.save(movie);
        return toReturn.getId();
    }

    public Movie findByName(String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie findById(int id){return movieRepository.findById(id);}
}
