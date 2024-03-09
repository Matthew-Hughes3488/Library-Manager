package file.utils;

import Library.Book;

import java.io.IOException;
import java.util.List;

public class BookFileManager {
    private BookFileReader bookFileReader;
    private BookToJson bookToJson;
    private JsonFileWriter jsonFileWriter;

    public BookFileManager() {
        this.bookFileReader = new BookFileReader();
        this.bookToJson = new BookToJson();
        this.jsonFileWriter = new JsonFileWriter();
    }

    public List<Book> getBookList() throws IOException {
        return bookFileReader.readBooksFromJson();
    }

    public void writeBooksToJson (List<Book> books){
        jsonFileWriter.writeJsonToFile(bookToJson.convertToJson(books), "books_data.json");
    }
}
