package file.utils;

import Library.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

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
