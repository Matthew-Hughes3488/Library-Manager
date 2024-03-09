package File.utils;

import Library.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class BookToJson {
    private ObjectMapper mapper;

    public BookToJson() {
        this.mapper = new ObjectMapper();
    }

    public String convertToJson(List<Book> booksList) {
        try {
            return mapper.writeValueAsString(booksList);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
