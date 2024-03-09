package File.utils;

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

    public void writeJsonToFile(String jsonString) {
        try {
            // Get the absolute path of the resources folder
            String resourcesPath = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(".")).toURI()).toString();

            // Append the filename to the resources path
            String filePath = resourcesPath + "/" + "Books_data";

            // Write JSON string to file
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(jsonString);
                System.out.println("JSON data written to file: " + filePath);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
