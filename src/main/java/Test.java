import file.utils.*;
import library.Book;
import file.utils.ObjectToJson;
import library.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        BookFileManager bookFileManager = new BookFileManager();
        List<Book> books = bookFileManager.getBookList();
        ObjectToJson<Book> objectToJson = new ObjectToJson<Book>();

        System.out.println(objectToJson.convertToJson(books));
    }
}
