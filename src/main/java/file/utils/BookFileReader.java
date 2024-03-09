package file.utils;

import Library.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BookFileReader {
    private final String csvFile = "/books_data.csv";
    private final String splitBy = ",";
    Pattern pattern = Pattern.compile(",");

    public List<Book> readFile() {
        List<Book> books = null;

        try (InputStream inputStream = getClass().getResourceAsStream(csvFile);
             BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {

            books = in.lines().skip(1).map(line -> {
                String[] book = pattern.split(line);
                return new Book(Integer.parseInt(book[0]), book[1], book[2], book[3], book[4], book[5]);
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> readBooksFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file into a List<Book> using Jackson's TypeReference
        List<Book> books = objectMapper.readValue(new File(filePath), new TypeReference<List<Book>>(){});

        return books;
    }
}