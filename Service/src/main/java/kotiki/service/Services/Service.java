package kotiki.service.Services;

import kotiki.dao.entities.*;
import kotiki.dao.repos.*;
import kotiki.service.DTO.*;
import kotiki.service.IServices.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@org.springframework.stereotype.Service
public class Service implements IService {
    @Autowired
    CatRepo catRepo;
    @Autowired
    FriendshipRepo friendshipRepo;
    @Autowired
    OwnershipRepo ownershipRepo;
    @Autowired
    OwnerRepo ownerRepo;

    public String getAllCats() {
        String result = "";
        List<Cat> cats = catRepo.findAll();
        List<CatDTO> catDTOs = new ArrayList<>();
        for (Cat cat : cats){
            CatDTO catDTO = new CatDTO(cat.getId(), cat.getName(), cat.getDateOfBirth(), cat.getBreed(), cat.getColour().toString());
            catDTOs.add(catDTO);
        }
        for (CatDTO catDTO : catDTOs){
            result += catDTO.toString() + "\n";
        }
        return result;//переделать дтошки в контроллер
    }
    public String getCat( Integer id){
        Cat cat = catRepo.findOneById(id);
        if (cat==null){
            return ("no such cat");
        }
        CatDTO catDTO = new CatDTO(cat.getId(), cat.getName(), cat.getDateOfBirth(), cat.getBreed(), cat.getColour().toString());
        return catDTO.toString();
    }
    public String getCatByBreed(  String breed){
        List<Cat> cats = catRepo.findByBreed(breed);
        String result = "";
        List<CatDTO> catDTOs = new ArrayList<>();
        for (Cat cat : cats){
            CatDTO catDTO = new CatDTO(cat.getId(), cat.getName(), cat.getDateOfBirth(), cat.getBreed(), cat.getColour().toString());
            catDTOs.add(catDTO);
        }
        for (CatDTO catDTO : catDTOs){
            result += catDTO.toString() + "\n";
        }
        return result;
    }
    public String deleteCat(  Integer id){
        if (catRepo.findOneById(id)==null){
            return ("no such cat");
        }
        catRepo.deleteById(id);
        return "cat deleted successfully";
    }
    public String getAllFriendsOfCatById(int id){
        Cat newCat = catRepo.findOneById(id);
        if (newCat==null){
            return ("no such cat");
        }
        List<Friendship> arr1 = friendshipRepo.findFriendshipsByFirstCat(newCat);
        System.out.println(arr1.isEmpty());
        List<Friendship> arr2 = friendshipRepo.findFriendshipsBySecondCat(newCat);
        List<Cat> cats = new ArrayList<>();
        for (Friendship friendship : arr1){
            cats.add(friendship.getSecondCat());
        }
        for (Friendship friendship : arr2){
            cats.add(friendship.getFirstCat());
        }
        List<CatDTO> catDTOs = new ArrayList<>();
        for (Cat cat : cats){
            CatDTO catDTO = new CatDTO(cat.getId(), cat.getName(), cat.getDateOfBirth(), cat.getBreed(), cat.getColour().toString());
            catDTOs.add(catDTO);
        }
        String result = "";
        for (CatDTO catDTO : catDTOs){
            result += catDTO.toString() + "\n";
        }
        return result;
    }
    public String updateCat(  Integer id,   String name){
        Cat cat = catRepo.findOneById(id);
        if (cat==null){
            return ("no such cat");
        }
        cat.setName(name);
        catRepo.save(cat);
        return ("cat updated successfully");
    }
    public String addCat(  String name,   String dateOfBirth,   String breed,   Integer colour) throws ParseException {
//        String[] date = dateOfBirth.split("-");
//        Date newDate = new Date();
//        newDate.setYear(Integer.parseInt(date[0])-1900);
//        newDate.setDate(Integer.parseInt(date[1]));
//        newDate.setMonth(Integer.parseInt(date[2]));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date newDate = format.parse(dateOfBirth);
        Cat cat = new Cat(name,newDate,breed, Cat.COLOUR.values()[colour]);
        catRepo.saveAndFlush(cat);
        return "cat added successfully";
    }
    public String getAllFriendships() {
        String result = "";
        List<Friendship> friendships = friendshipRepo.findAll();
        List<FriendshipDTO> friendshipDTOs = new ArrayList<>();
        for (Friendship friendship : friendships){
            FriendshipDTO friendshipDTO = new FriendshipDTO(friendship.getId(), friendship.getFirstCat(), friendship.getSecondCat());
            friendshipDTOs.add(friendshipDTO);
        }
        for (FriendshipDTO friendshipDTO : friendshipDTOs){
            result += friendshipDTO.toString() + "\n";
        }
        return result;
    }
    public String getFriendship(Integer id){
        Friendship friendship = friendshipRepo.findOneById(id);
        if (friendship==null){
            return ("no such friendship");
        }
        FriendshipDTO friendshipDTO = new FriendshipDTO (friendship.getId(), friendship.getFirstCat(),friendship.getSecondCat());
        return friendshipDTO.toString();
    }
    public String deleteFriendship(Integer id){
        if (friendshipRepo.findOneById(id)==null){
            return ("no such friendship");
        }
        friendshipRepo.deleteById(id);
        return "friendship deleted succesfully";
    }
    public String addFriendship( int catId1, int catId2) {
        Cat cat1 = catRepo.getOne(catId1);
        Cat cat2 = catRepo.getOne(catId2);
        Friendship friendship = new Friendship(cat1,cat2);
        friendshipRepo.saveAndFlush(friendship);
        return "friendship added successfully";
    }
    public String getAllOwners() {
        String result = "";
        List<Owner> owners = ownerRepo.findAll();
        List<OwnerDTO> ownerDTOS = new ArrayList<>();
        for (Owner owner : owners){
            OwnerDTO ownerDTO = new OwnerDTO(owner.getId(), owner.getName(), owner.getDateOfBirth());
            ownerDTOS.add(ownerDTO);
        }
        for (OwnerDTO ownerDTO:ownerDTOS){
            result += ownerDTO.toString() + "\n";
        }
        return result;
    }
    public String getOwner( Integer id){
        Owner owner = ownerRepo.findOneById(id);
        if (owner==null){
            return ("no such owner");
        }
        OwnerDTO ownerDTO = new OwnerDTO(owner.getId(), owner.getName(), owner.getDateOfBirth());
        return ownerDTO.toString();
    }
    public String deleteOwner( Integer id){
        if (ownerRepo.findOneById(id)==null){
            return ("no such owner");
        }
        ownerRepo.deleteById(id);
        return "owner deleted succesfully";
    }
    public String addOwner( String name,  String dateOfBirth) throws ParseException {
        String[] date = dateOfBirth.split("-");
        Date newDate = new Date();
        newDate.setYear(Integer.parseInt(date[0])-1900);
        newDate.setDate(Integer.parseInt(date[1]));
        newDate.setMonth(Integer.parseInt(date[2]));
        Owner owner = new Owner(name,newDate);
        ownerRepo.saveAndFlush(owner);
        return "owner added successfully";
    }
    public String getAllOwnerships() {
        String result = "";
        List<Ownership> ownerships = ownershipRepo.findAll();
        List<OwnershipDTO> ownershipDTOs = new ArrayList<>();
        for (Ownership ownership : ownerships){
            OwnershipDTO ownershipDTO = new OwnershipDTO(ownership.getId(), ownership.getOwnerId(),ownership.getCat());
            ownershipDTOs.add(ownershipDTO);
        }
        for (OwnershipDTO ownershipDTO : ownershipDTOs){
            result += ownershipDTO.toString() + "\n";
        }
        return result;
    }
    public String getOwnership( Integer id){
        Ownership ownership = ownershipRepo.findOneById(id);
        if (ownership==null){
            return ("no such owner");
        }
        OwnershipDTO ownershipDTO = new OwnershipDTO(ownership.getId(), ownership.getOwnerId(),ownership.getCat());
        return ownershipDTO.toString();
    }
    public String getAllOwnershipsOfOwner(int id){
        List<Ownership> ownerships = ownershipRepo.findOwnershipsByOwnerId(id);
        if (ownerships.isEmpty()){
            return ("this owner has 0 ownerships");
        }
        List<CatDTO> catDTOs = new ArrayList<>();
        for (Ownership ownership : ownerships){
            Cat cat = catRepo.getOne(ownership.getCat().getId());
            CatDTO catDTO = new CatDTO(cat.getId(), cat.getName(), cat.getDateOfBirth(), cat.getBreed(), cat.getColour().toString());
            catDTOs.add(catDTO);
        }
        return catDTOs.toString();
    }
    public String deleteOwnership( Integer id){
        if (ownershipRepo.findOneById(id)==null){
            return ("no such ownership");
        }
        ownershipRepo.deleteById(id);
        return "ownership deleted succesfully";
    }
    public String addOwnership( int catId,  int ownerId) {
        Cat cat = catRepo.getOne(catId);
        Ownership ownership = new Ownership(ownerId,cat );
        ownershipRepo.saveAndFlush(ownership);
        return "ownership added successfully";
    }

}
