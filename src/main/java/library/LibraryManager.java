package library;

import utils.InputManager;
import utils.OutputManager;

public class LibraryManager {
    private BookLoanManager bookLoanManager;
    private InputManager inputManager;
    private OutputManager outputManager;
    private User user;

    public LibraryManager(BookLoanManager bookLoanManager, InputManager inputManager, OutputManager outputManager, User user) {
        this.bookLoanManager = bookLoanManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.user = user;
    }

    // ask for user inputs on a loop until
    public void mainLoop(){
        while(true){
            outputManager.printCommands();
            System.out.println("Please enter a command: ");
            int userInput = inputManager.getIntInput(0, 5);

            processInput(userInput);
        }
    }

    private boolean processInput(int input) {
        switch (input){
            case 0:
                //create new user
            case 1:
                //validate user
            case 2:
                //list all books
            case 3:
                //checkout book
            case 4:
                //return book
            case 5:
                return false;
        }
        return true;
    }
}
