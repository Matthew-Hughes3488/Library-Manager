package file.utils;

import library.Book;

import java.io.IOException;
import java.util.List;

public class BookFileManager {
    private BookFileReader bookFileReader;
    private ObjectToJson<Book> objectToJson;
    private JsonFileWriter jsonFileWriter;

    public BookFileManager() {
        this.bookFileReader = new BookFileReader();
        this.objectToJson = new ObjectToJson<Book>();
        this.jsonFileWriter = new JsonFileWriter();
    }

    public List<Book> getBookList() throws IOException {
        return bookFileReader.readBooksFromJson();
    }

    public void writeBooksToJson (List<Book> books){
        jsonFileWriter.writeJsonToFile(objectToJson.convertToJson(books), "books_data.json");
    }
}
