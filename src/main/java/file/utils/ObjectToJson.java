package file.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class ObjectToJson<T> {
    private final ObjectMapper mapper;

    public ObjectToJson() {
        this.mapper = new ObjectMapper();
    }

    public String convertToJson(List<T> objectList) {
        try {
            return mapper.writeValueAsString(objectList);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
