package library;

import file.utils.JsonFileWriter;

import java.util.List;

public class BookLoanManager {
    private User currentUser;
    private List<Book> books;
    private List<Book> booksOnLoan;
    private JsonFileWriter jsonFileWriter = new JsonFileWriter();
    public BookLoanManager(User currentUser, List<Book> books, List<Book> booksOnLoan) {
        this.currentUser = currentUser;
        this.books = books;
        this.booksOnLoan = booksOnLoan;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public void checkout(int bookId){
        Book book = books.get(bookId);

        if(isCheckedOut(book))
            System.out.println("Sorry, this book is not available");
        else {
            currentUser.checkout(book);
            booksOnLoan.add(book);
        }
    }
    public void checkin(int bookId){
        Book book = books.get(bookId);

        if(isCheckedOut(book))
            booksOnLoan.remove(book);
        else
            System.out.println("Book is not out on loan");
    }
    public void printAllBooks(){
        for (Book book : books){
            System.out.println(book);
        }
    }
    private boolean isCheckedOut(Book book) {
        return booksOnLoan.contains(book);
    }
}
