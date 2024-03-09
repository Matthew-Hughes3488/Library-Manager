import File.utils.BookCsvReader;
import File.utils.BookToJson;
import Library.Book;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        BookCsvReader bookCsvReader = new BookCsvReader();
        BookToJson bookToJson = new BookToJson();
        List<Book> books = bookCsvReader.readFile();
        bookToJson.writeJsonToFile(bookToJson.convertToJson(books));
        System.out.println(bookToJson.convertToJson(books));
    }
}
