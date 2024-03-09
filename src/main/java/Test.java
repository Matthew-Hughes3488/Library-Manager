import library.Book;
import file.utils.BookFileReader;
import file.utils.BookToJson;
import file.utils.JsonFileWriter;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        BookFileReader bookFileReader = new BookFileReader();
        BookToJson bookToJson = new BookToJson();
        JsonFileWriter jsonFileWriter = new JsonFileWriter();
        List<Book> books = bookFileReader.readFile();
        jsonFileWriter.writeJsonToFile(bookToJson.convertToJson(books), "Books_data");
        books = bookFileReader.readBooksFromJson();
        System.out.println(books);
    }
}
