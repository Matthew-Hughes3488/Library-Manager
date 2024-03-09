package File.utils;

import Library.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BookFileReader {
    private String csvFile;
    private String splitBy = ",";

    public BookFileReader(String csvFile) {
        this.csvFile = csvFile;
    }

    public List<Book> readFile() {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(csvFile)))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                Book book = dataToBook(data);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private Book dataToBook(String[] data){
        if(data.length < 6){
            throw new IllegalArgumentException("Data format is incorrect");
        }

        int id = Integer.parseInt(data[0]);
        String title = data[1];
        String author = data[2];
        String genre = data[3];
        String subGenre = data[4];
        String publisher = data[5];

        return new Book(id, title, author, genre, subGenre, publisher);
    }
}
