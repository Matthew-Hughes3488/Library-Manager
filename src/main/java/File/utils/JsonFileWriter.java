package File.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

public class JsonFileWriter {

    public void writeJsonToFile(String jsonString, String fileName) {
        try {
            // Get the absolute path of the resources folder
            String resourcesPath = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(".")).toURI()).toString();

            // Append the filename to the resources path
            String filePath = resourcesPath + "/" + fileName;

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
