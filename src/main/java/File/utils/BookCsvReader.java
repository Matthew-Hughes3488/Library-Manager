package File.utils;

import Library.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BookCsvReader {
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
}