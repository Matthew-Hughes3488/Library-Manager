package file.utils;

import library.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BookFileReader {
    private final String csvFile = "/books_data.csv";
    private final String splitBy = ",";
    private final ObjectMapper mapper = new ObjectMapper();
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
    public List<Book> readBooksFromJson() throws IOException {

        File jsonFile = new File("target/classes/books_data.json");
        List<Book> books = mapper.readValue(jsonFile, new TypeReference<List<Book>>() {});

        return books;
    }

    public List<Book> readBooksOnLoanFromJson() throws IOException {

        File jsonFile = new File("target/classes/loaned_books_data.json");

        if (fileIsEmpty(jsonFile)){
            return new ArrayList<Book>();
        }
        List<Book> books = mapper.readValue(jsonFile, new TypeReference<List<Book>>() {});

        return books;
    }

    private boolean fileIsEmpty(File file){
        return file.length() == 0;
    }
}