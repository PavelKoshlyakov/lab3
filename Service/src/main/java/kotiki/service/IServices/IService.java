package kotiki.service.IServices;


import java.text.ParseException;

public interface IService {
    public String getAllCats();
    public String getCat(Integer id);
    public String getCatByBreed(String breed);
    public String deleteCat(Integer id);
    public String getAllFriendsOfCatById(int id);
    public String updateCat( Integer id, String name);
    public String addCat( String name, String dateOfBirth, String breed, Integer colour) throws ParseException;
    public String getAllFriendships();
    public String getFriendship( Integer id);
    public String deleteFriendship( Integer id);
    public String addFriendship( int catId1,  int catId2);
    public String getAllOwners();
    public String getOwner( Integer id);
    public String deleteOwner( Integer id);
    public String addOwner( String name,  String dateOfBirth) throws ParseException;
    public String getAllOwnerships();
    public String getOwnership( Integer id);
    public String getAllOwnershipsOfOwner(int id);
    public String deleteOwnership( Integer id);
    public String addOwnership( int catId,  int ownerId);

}

