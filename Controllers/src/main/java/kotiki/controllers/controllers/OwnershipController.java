package kotiki.controllers.controllers;
import kotiki.service.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnershipController {
    @Autowired
    Service service;

    @GetMapping("/ownership/get_all")
    public String getAllOwnerships() {
       return service.getAllOwnerships();
    }
    @GetMapping("/ownership/get")
    public String getOwnership(@RequestParam Integer id){
        return service.getOwnership(id);
    }
    @GetMapping("/ownership/get_ownerships_of_owner")
    public String getAllOwnershipsOfOwner(@RequestParam int id){
        return service.getAllOwnershipsOfOwner(id);
    }
    @DeleteMapping("/ownership/delete")//??post
    public String deleteOwnership(@RequestParam Integer id){
       return service.deleteOwnership(id);
    }
    @PostMapping("/ownership/add")
    public String addOwnership(@RequestParam int catId, @RequestParam int ownerId) {
        return service.addOwnership(catId, ownerId);
    }
}
