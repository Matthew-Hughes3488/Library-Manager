package file.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserFileReader {
    private final ObjectMapper mapper = new ObjectMapper();
    private final ObjectToJson<User> userObjectToJson = new ObjectToJson<User>();

    public List<User> readUserFromJson() throws IOException {

        File jsonFile = new File("target/classes/users_data.json");
        List<User> users = mapper.readValue(jsonFile, new TypeReference<List<User>>() {});

        return users;
    }
}
