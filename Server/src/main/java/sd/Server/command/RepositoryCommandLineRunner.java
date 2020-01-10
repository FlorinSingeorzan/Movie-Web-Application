package sd.Server.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sd.Server.repositories.MovieRepository;
import sd.Server.repositories.StaffRepository;
import sd.Server.repositories.UserRepository;


@Component
public class RepositoryCommandLineRunner implements CommandLineRunner {


    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final StaffRepository staffRepository;

    @Autowired
    public RepositoryCommandLineRunner(UserRepository userRepository, MovieRepository movieRepository, StaffRepository staffRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.staffRepository = staffRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        userRepository.findAll().forEach(System.out::println);
    }
}
