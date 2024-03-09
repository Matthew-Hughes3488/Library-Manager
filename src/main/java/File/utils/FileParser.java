package File.utils;

import Library.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private String csvFile = "/books_data.csv";
    private String splitBy = ",";

    public FileParser() {
    }

    public FileParser(String csvFile) {
        this.csvFile = csvFile;
    }

    public List<Book> readFile() {
        List<Book> books = new ArrayList<>();

        // Load the file as a resource using the class loader
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(csvFile)))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                if (data.length >= 6) { // Ensure the line has enough fields
                    int id = Integer.parseInt(data[0]); // Assuming the first field is the identifier
                    String title = data[1];
                    String author = data[2];
                    String genre = data[3];
                    String subGenre = data[4];
                    String publisher = data[5];

                    Book book = new Book(id, title, author, genre, subGenre, publisher);
                    books.add(book);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}
