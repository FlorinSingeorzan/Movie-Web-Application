package sd.Server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import sd.Server.entities.UserApi;
import sd.Server.services.UserService;


import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class UserController {
    private final UserService services;

    @Autowired
    public UserController(UserService services){
        this.services = services;
    }

    @GetMapping("/users")
    public Collection<UserApi> userSetApi(){
        return services.findAll();
    }

    @GetMapping("/users/{id}")
    public UserApi userEntityApi(@PathVariable int id){
        return services.findById(id);
    }

    @RequestMapping(value = "/user/{name}",method = RequestMethod.GET)
    public UserApi getUserByName(@PathVariable("name") String name){
        return services.findByName(name);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable Integer id){
         return services.delete(id);
    }
    @PostMapping("/users/create")
    public int createUser(@RequestBody UserApi userApi){
         return services.create(userApi);
    }

   @PutMapping("/users/update")
    public int updateUser(@RequestBody UserApi userApi){
         return services.update(userApi);
    }



}
