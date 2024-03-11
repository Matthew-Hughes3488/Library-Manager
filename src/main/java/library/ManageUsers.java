package library;

import java.util.List;

public class ManageUsers {
    List<User> users;
    NewUser newUser;

    public ManageUsers(List<User> users) {
        this.users = users;
        newUser = new NewUser(users);
    }

    public boolean validateUser(String username, String password){
        return ValidateUser.isUserValid(username, password, users);
    }

    public void createNewUser(){
        newUser.registerNewUser();
    }
}
