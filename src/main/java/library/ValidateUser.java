package library;

import java.util.List;

public class ValidateUser {
    public static boolean isUserValid(String username, String password, List<User> users){
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
