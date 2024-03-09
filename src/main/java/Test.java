import File.utils.BookCsvReader;
import Library.Book;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        BookCsvReader bookCsvReader = new BookCsvReader();
        List<Book> books = bookCsvReader.readFile();
        System.out.println("done");
    }
}
