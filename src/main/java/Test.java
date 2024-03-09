import Library.Book;
import file.utils.BookFileReader;
import file.utils.BookToJson;
import file.utils.JsonFileWriter;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        BookFileReader bookFileReader = new BookFileReader();
        BookToJson bookToJson = new BookToJson();
        JsonFileWriter jsonFileWriter = new JsonFileWriter();
        List<Book> books = bookFileReader.readFile();
        jsonFileWriter.writeJsonToFile(bookToJson.convertToJson(books), "books_data");
        System.out.println(bookToJson.convertToJson(books));
    }
}
