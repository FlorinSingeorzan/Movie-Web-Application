package sd.Server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sd.Server.entities.Feedback;
import sd.Server.services.FeedbackService;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class FeedbackController {

    private final FeedbackService services;

    @Autowired
    public FeedbackController(FeedbackService services){
        this.services = services;
    }

    @GetMapping("/feedback")
    public Collection<Feedback> getAllFeedbacks(){
        return services.findAll();
    }

    @DeleteMapping("/feedbacks/{id}")
    public boolean deleteFeedback(@PathVariable Integer id){
        return services.delete(id);
    }
    @PostMapping("/feedbacks/create")
    public int addFeedback(@RequestBody Feedback feedback){
        return services.create(feedback);
    }

    @PutMapping("/feedbacks/update")
    public int updateFeedback(@RequestBody Feedback feedback){
        return services.update(feedback);
    }

    @GetMapping("/feedbacks/{movie}")
    public Collection<Feedback> getFeedbackByMovieId(@PathVariable int movie){
        return services.findByMovieId(movie);
    }

    @GetMapping("/feedbacks/{movieId}/{userId}")
    public Feedback getFeedbackByMovieId(@PathVariable int movieId, @PathVariable int userId){
        return services.findByMovieIdAndUserId(movieId,userId);
    }

    @GetMapping("/mfeedbacks/{movieId}")
    public Collection<Feedback> getMovieFeedbacks(@PathVariable int movieId){
        return services.findByMovieId(movieId);
    }

}
