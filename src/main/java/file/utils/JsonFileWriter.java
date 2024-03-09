package file.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonFileWriter {

    public void writeJsonToFile(String jsonString, String fileName) {
        try {
            String outputDirectory = Paths.get("target", "classes").toString();

            String filePath = outputDirectory + "/" + fileName;

            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(jsonString);
                System.out.println("JSON data written to file: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
