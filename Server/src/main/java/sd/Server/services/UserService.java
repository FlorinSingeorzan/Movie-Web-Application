package sd.Server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.Server.entities.UserApi;
import sd.Server.repositories.UserRepository;
import java.util.Base64;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserApi> findAll() {
          return userRepository.findAll();
    }

    public boolean delete(int id){
            userRepository.deleteById(id);
        return true;
    }

    public int create(UserApi userApi){
        if (userApi!=null && !userApi.getPassword().equals("") && !userApi.getName().equals("") && userRepository.findByName(userApi.getName())==null) {
            String pass = userApi.getPassword();
            String encodedPass = Base64.getEncoder().encodeToString(pass.getBytes());
            userApi.setPassword(encodedPass);
            UserApi toReturn = userRepository.save(userApi);
            return toReturn.getId();
        }
        return -1;
    }

    public int update(UserApi userApi) {
        return create(userApi);
    }

    public UserApi findByName(String name) {
        UserApi user =userRepository.findByName(name);
        if (user == null){
            return null;
        }
        String pass =user.getPassword();
        byte[] decodedBytes = Base64.getDecoder().decode(pass);
        String decodedPass = new String(decodedBytes);
        user.setPassword(decodedPass);
        return user;
    }

    public UserApi findById(int id) {
        UserApi user =userRepository.findById(id);
        String pass =user.getPassword();
        byte[] decodedBytes = Base64.getDecoder().decode(pass);
        String decodedPass = new String(decodedBytes);
        user.setPassword(decodedPass);
        return user;
    }
}
