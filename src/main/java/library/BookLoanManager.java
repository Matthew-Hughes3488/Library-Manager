package library;

import java.util.List;

public class BookLoanManager {
    private User currentUser;
    private List<Book> books;
    private List<Book> booksOnLoan;
    public BookLoanManager(User currentUser, List<Book> books, List<Book> booksOnLoan) {
        this.currentUser = currentUser;
        this.books = books;
        this.booksOnLoan = booksOnLoan;
    }
    public void checkout(Book book){
        if(isCheckedOut(book))
            System.out.println("Sorry, this book is not available");
        else {
            currentUser.checkout(book);
            booksOnLoan.add(book);
        }
    }
    private boolean isCheckedOut(Book book) {
        return booksOnLoan.contains(book);
    }
}
