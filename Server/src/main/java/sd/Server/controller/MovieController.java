package sd.Server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sd.Server.entities.Movie;
import sd.Server.services.MovieService;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class MovieController {

    private final MovieService services;

    @Autowired
    public MovieController(MovieService services){
        this.services = services;
    }

    @GetMapping("/movies")
    public Collection<Movie> getAllMovies(){
        return services.findAll();
    }

    @RequestMapping(value = "/movie/{name}",method = RequestMethod.GET)
    public Movie getMovieByName(@PathVariable("name") String name){
        return services.findByName(name);
    }

    @RequestMapping(value = "/movies/{id}",method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable("id") int id){
        return services.findById(id);
    }

    @DeleteMapping("/movies/{id}")
    public boolean DeleteMovie(@PathVariable Integer id){
        return services.delete(id);
    }
    @PostMapping("/movies/create")
    public int addMovie(@RequestBody Movie movie){
        return services.create(movie);
    }

    @PutMapping("/movies/update")
    public int updateMovie(@RequestBody Movie movie){
        return services.update(movie);
    }

}
