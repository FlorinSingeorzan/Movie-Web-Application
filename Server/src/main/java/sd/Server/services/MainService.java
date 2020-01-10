package sd.Server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.Server.entities.*;
import sd.Server.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    private final UserRepository userRepository;
    private final FeedbackRepository feedbackRepository;
    private final MovieRepository movieRepository;
    private final RoleRepository roleRepository;
    private final StaffRepository staffRepository;

    @Autowired
    public MainService(UserRepository userRepository, FeedbackRepository feedbackRepository, MovieRepository movieRepository, RoleRepository roleRepository, StaffRepository staffRepository) {
        this.userRepository=userRepository;
        this.feedbackRepository = feedbackRepository;
        this.movieRepository = movieRepository;
        this.roleRepository = roleRepository;
        this.staffRepository = staffRepository;
    }


    public int userExistance(String username, String password){
        UserApi userApi= userRepository.findByName(username);

        if (userApi.getPassword().equals(password)){
            return userApi.getRole();
        }
        return -1;
    }


    public int addFeedback(String type, Feedback feedback) {
        Feedback dbFeedback = feedbackRepository.findByUserIdAndMovieId(feedback.getUserId(),feedback.getMovieId());
        switch(type){
            case "REVIEW":
                dbFeedback.setReview(feedback.getReview());
                feedbackRepository.save(feedback);
                break;

            case "RATE":
                if(feedback.getRate()>1 && feedback.getRate()<=10) {
                    dbFeedback.setRate(feedback.getRate());
                }
                feedbackRepository.save(feedback);
                break;

            case "WATCHED":
                if(feedback.getWatched()==1 || feedback.getWatched()==0) {
                    dbFeedback.setWatched(feedback.getWatched());
                }
                feedbackRepository.save(feedback);
                break;
            case "ALL":
                feedbackRepository.save(feedback);
                break;
            default:
                break;
        }


        return feedback.getId();
    }

    public List<Movie> createTop(int rate){
        List<Movie> topMovies=new ArrayList<>();
        int progresive =rate;
        while (progresive<=10){
            topMovies.addAll(movieRepository.findAllByRate(progresive));

            progresive++;
        }


        return topMovies;
    }


    public List<Movie> singleLanguage(String lang) {
        List<Movie> topMovies=new ArrayList<>();

        for(Movie dbMovie: movieRepository.findAll()){
            if(dbMovie.getLanguages().contains(lang)){
                topMovies.add(dbMovie);
            }
        }
        return topMovies;
    }

    public List<Movie> findWatched(int userId) {
        List<Feedback> feedbacks= feedbackRepository.findByUserId(userId);
        List<Movie> wMovies = new ArrayList<>();
        for (Feedback feed: feedbacks){
            if (feed.getWatched()==1){
                int id = feed.getMovieId();
                wMovies.add(movieRepository.findById(id));
            }
        }
        return wMovies;
    }


    void sendMail(String title) {
        final MailService mailService = new MailService("dummy.singeorzan96", "dummy");
        List<UserApi> users = userRepository.findAll();
        for (UserApi u : users) {
            if (u.getEmail()!=null && u.getEmail().contains("@gmail.com")) {
                mailService.sendMail(u.getEmail(), title + " is now available", title);
            }
        }
    }

    public List<Staff> getActors(int movieId) {
        List<Staff> staffs = new ArrayList<>();
        List<Role> roles = roleRepository.findByIdMovie(movieId);
        for(Role r: roles){
            Staff staff = staffRepository.findById(r.getIdStaff());
            staffs.add(staff);
        }
        return staffs;
    }
}
