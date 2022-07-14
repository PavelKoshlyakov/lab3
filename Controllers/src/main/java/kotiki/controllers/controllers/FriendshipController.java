package kotiki.controllers.controllers;
import kotiki.service.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FriendshipController {
    @Autowired
    Service service;

    @GetMapping("/friendship/get_all")
    public String getAllFriendships() {
        return service.getAllFriendships();
    }
    @GetMapping("/friendship/get")
    public String getFriendship(@RequestParam Integer id){
        return service.getFriendship(id);
    }
    @DeleteMapping("/friendship/delete")
    public String deleteFriendship(@RequestParam Integer id){
        return  service.deleteFriendship(id);
    }
    @PostMapping("/friendship/add")
    public String addFriendship(@RequestParam int catId1, @RequestParam int catId2) {
        return service.addFriendship(catId1,catId2);
    }
}
