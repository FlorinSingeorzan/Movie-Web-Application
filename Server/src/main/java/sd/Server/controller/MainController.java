package sd.Server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sd.Server.entities.Feedback;
import sd.Server.entities.Movie;
import sd.Server.entities.Staff;
import sd.Server.services.MainService;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String loginApi(@RequestParam("username") String username,
                           @RequestParam("password") String password, ModelMap model, HttpSession session) {
        model.addAttribute("username_i", username);
        model.addAttribute("password_i", password);
        switch (mainService.userExistance(username, password)) {
            case 0:
                session.setAttribute("Login", "ADMIN");
                break;
            case 1:
                session.setAttribute("Login", "REGULAR");
                break;
            default:
                session.setAttribute("Login", "NONE");
                break;
        }
        return "redirect:/value";
    }

    @RequestMapping(value = "/logout",method = {RequestMethod.GET})
    public String logout(ModelMap model, HttpSession session){
            model.addAttribute("username_i","");
            model.addAttribute("password_i","");
            session.setAttribute("Login","NONE");
        return "redirect:/value";
    }

    @RequestMapping(value = "/addFeedback/{type}",method =  RequestMethod.POST)
    public int addFeedback( @RequestBody Feedback feedback, @PathVariable String type){
        return mainService.addFeedback(type,feedback);
    }

    @RequestMapping(value = "/highrate/{rate}")
    public Collection<Movie> addFeedback( @PathVariable int rate){
        return mainService.createTop(rate);
    }

    @RequestMapping(value = "/language/{lang}")
    public Collection<Movie> addFeedback(@PathVariable String lang){
        return mainService.singleLanguage(lang);
    }

    @RequestMapping(value = "/watched/{userId}")
    public Collection<Movie> findWatched( @PathVariable int userId){
        return mainService.findWatched(userId);
    }

    @RequestMapping(value = "/actors/{movieId}")
    public Collection<Staff> getMovieActors(@PathVariable int movieId){
        return mainService.getActors(movieId);
    }


}
