package kotiki.controllers.controllers;
import kotiki.service.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

@RestController
public class CatController {
    @Autowired
    Service service;

    @GetMapping("/cat/get_all")
    public String getAllCats() {
        return service.getAllCats();
    }
    @GetMapping("/cat/get")
    public String getCat(@RequestParam Integer id){
        return service.getCat(id);
    }
    @GetMapping("/cat/get_by_breed")
    public String getCatByBreed(@RequestParam String breed){
       return service.getCatByBreed(breed);
    }
    @DeleteMapping("/cat/delete")
    public String deleteCat(@RequestParam Integer id){
        return service.deleteCat(id);
    }
    @GetMapping("/cat/find_friends")
    public String getAllFriendsOfCatById(int id){
        return service.getAllFriendsOfCatById(id);
    }
    @PostMapping("/cat/update")
    public String updateCat(@RequestParam Integer id, @RequestParam String name){
        return service.updateCat(id,name);
    }
    @PostMapping("/cat/add")
    public String addCat(@RequestParam String name, @RequestParam String dateOfBirth, @RequestParam String breed, @RequestParam Integer colour) throws ParseException {
        return service.addCat(name, dateOfBirth, breed, colour);
    }
}
