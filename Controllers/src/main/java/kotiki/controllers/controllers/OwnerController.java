package kotiki.controllers.controllers;

import kotiki.service.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

@RestController
public class OwnerController {
    @Autowired
    Service service;

    @GetMapping("/owner/get_all")
    public String getAllOwners() {
       return service.getAllOwners();
    }
    @GetMapping("/owner/get")
    public String getOwner(@RequestParam Integer id){
        return service.getOwner(id);
    }
    @DeleteMapping("/owner/delete")
    public String deleteOwner(@RequestParam Integer id){
       return service.deleteOwner(id);
    }
    @PostMapping("/owner/add")
    public String addOwner(@RequestParam String name, @RequestParam String dateOfBirth) throws ParseException {
        return service.addOwner(name, dateOfBirth);
    }

}
