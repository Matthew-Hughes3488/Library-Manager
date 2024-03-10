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
        while(true) {
            outputManager.printCommands();
            System.out.println("Please enter a command: ");
            int userInput = inputManager.getIntInput(0, 6);

            if (!processInput(userInput)){
                processAppClose();
                break;
            }
        }
    }

    private boolean processInput(int input) {
        switch (input){
            case 0:
                //create new user
            case 1:
                //validate user
            case 2:
                bookLoanManager.printAllBooks();
                break;
            case 3:
                processCheckout();
                break;
            case 4:
                processReturn();
                break;
            case 5:
                //print report
            case 6:
                return false;
        }
        return true;
    }

    //CLASS HERE TO PROCESS APP CLOSING I.E. WRITING THE DATA TO THE JSON FILES
    private void processAppClose(){

    }

    private void processLogin(){
    }

    private void processNewUser(){
    }

    private void processLogout(){
    }

    private void processReturn() {
        System.out.println("Enter the Id of the book you want to return");
        int input = inputManager.getIntInput(0, 50);

        bookLoanManager.checkin(input);
    }
    private void processCheckout() {
        System.out.println("Enter the Id of the book you want to checkout");
        int input = inputManager.getIntInput(0, 50);

        bookLoanManager.checkout(input);
    }
}
