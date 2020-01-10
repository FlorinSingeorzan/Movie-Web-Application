package sd.Server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sd.Server.entities.Role;
import sd.Server.services.RoleService;

import java.util.Collection;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class RoleController {

    private final RoleService services;

    @Autowired
    public RoleController(RoleService services){
        this.services = services;
    }

    @GetMapping("/roles")
    public Collection<Role> getAllRoles(){
        return services.findAll();
    }


    @DeleteMapping("/role/{id}")
    public boolean deleteRole(@PathVariable Integer id){
        return services.delete(id);
    }
    @PostMapping("/roles/create")
    public int addRole(@RequestBody Role role){
        return services.create(role);
    }

    @PutMapping("/roles/update")
    public int updateRole(@RequestBody Role role){
        return services.update(role);
    }

}
