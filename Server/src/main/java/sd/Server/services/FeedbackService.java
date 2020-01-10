package sd.Server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.Server.entities.Feedback;
import sd.Server.repositories.FeedbackRepository;


import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository= feedbackRepository;
    }


    public List<Feedback> findAll() {

        return feedbackRepository.findAll();
    }

    public boolean delete(int id){
        feedbackRepository.deleteById(id);
        return true;
    }

    public int create(Feedback movie){
        Feedback toReturn= feedbackRepository.save(movie);
        return toReturn.getId();
    }

    public int update(Feedback movie) {
        Feedback toReturn= feedbackRepository.save(movie);
        return toReturn.getId();
    }

    public List<Feedback> findByMovieId(int movieId){
        return feedbackRepository.findByMovieId(movieId);
    }

    public Feedback findByMovieIdAndUserId(int movieId, int userId){
        return feedbackRepository.findByUserIdAndMovieId(userId,movieId);
    }




}
