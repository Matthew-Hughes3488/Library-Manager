import File.utils.FileParser;
import Library.Book;

import java.io.FileReader;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        List<Book> books = fileParser.readFile();
        System.out.println("done");
    }
}
