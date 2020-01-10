package sd.Server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sd.Server.entities.Staff;
import sd.Server.services.StaffService;

import java.util.Collection;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {


    private final StaffService services;

    @Autowired
    public StaffController(StaffService services){
        this.services = services;
    }

    @GetMapping("/staffs")

    public Collection<Staff> getAllStaffs(){
        return services.findAll();
    }

    @RequestMapping(value = "/staff/{name}",method = RequestMethod.GET)
    public Staff getStaffByName(@PathVariable("name") String name){
        return services.findByName(name);
    }

    @RequestMapping(value = "/staffs/{id}",method = RequestMethod.GET)
    public Staff getStaffById(@PathVariable("id") int id){
        return services.findById(id);
    }

    @DeleteMapping("/staffs/{id}")
    public boolean deleteStaff(@PathVariable Integer id){
        return services.delete(id);
    }
    @PostMapping("/staffs/create")
    public int addStaff(@RequestBody Staff staff){
        return services.create(staff);
    }

    @PutMapping("/staffs/update")
    public int updateStaff(@RequestBody Staff staff){
        return services.update(staff);
    }

}
