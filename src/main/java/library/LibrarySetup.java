package library;

import file.utils.BookFileReader;
import file.utils.UserFileReader;
import utils.InputManager;
import utils.OutputManager;

import java.io.IOException;
import java.util.List;

public class LibrarySetup {
    public static void main(String[] args) throws IOException {

        BookFileReader bookFileReader = new BookFileReader();
        List<Book> bookList = bookFileReader.readBooksFromJson();
        List<Book> booksOnLoanList = bookFileReader.readBooksOnLoanFromJson();

        UserFileReader userFileReader= new UserFileReader();
        List<User> users = userFileReader.readUserFromJson();
        User user = users.get(0);

        BookLoanManager bookLoanManager = new BookLoanManager(user, bookList, booksOnLoanList);

        String[] commands ={"Register New User", "Login", "List Books", "Checkout Book", "Return Book", "Print Report", "Quit"};

        LibraryManager libraryManager = new LibraryManager(bookLoanManager, new InputManager(), new OutputManager(commands), user);
        libraryManager.mainLoop();

    }
}
