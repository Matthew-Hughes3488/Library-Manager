package library;

import file.utils.JsonFileWriter;
import utils.InputManager;

import java.util.ArrayList;
import java.util.List;

public class NewUser {
    JsonFileWriter jsonFileWriter = new JsonFileWriter();
    InputManager inputManager = new InputManager();

    List<User> users;

    public NewUser(List<User> users) {
        this.users = users;
    }

    public void registerNewUser(){
        System.out.println("Please enter a username");
        String username = inputManager.getStringInput();
        
        if(usernameExists(username)){
            System.out.println("Username is taken");
            registerNewUser();
            return;
        }

        System.out.println("Please enter a password");
        String password = inputManager.getStringInput();

        createNewUser(username, password);
        System.out.println("New user created created");
    }

    private void createNewUser(String username, String password) {
        User user = new User(username, password, new ArrayList<>(), false);
        users.add(user);
    }

    private boolean usernameExists(String username) {
        for(User user : users){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
