package library;

import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Book> booksCheckedOut;
    private boolean isAdmin;

    public User(String username, String password, List<Book> booksCheckedOut, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.booksCheckedOut = booksCheckedOut;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String oldPassword, String newPassword) {
        if(oldPassword.equals(password)){
            this.password = newPassword;
        }
        else{
            System.out.println("Password change failed");
        }
    }

    public List<Book> getBooksCheckedOut() {
        return booksCheckedOut;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void checkout(Book book){
        booksCheckedOut.add(book);
    }

    public void returnBook(Book book){
        booksCheckedOut.remove(book);
    }
}
