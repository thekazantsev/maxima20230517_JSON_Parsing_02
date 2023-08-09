import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.cinema.Seance;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;

public class JacksonParserSeance {
    public static void main(String[] args) {
        File file = Path.of("src", "main", "resources", "Cinema.json").toFile();
        String charset = "UTF-8";

        try (FileReader fileReader = new FileReader(file, Charset.forName(charset));) {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<Map<String, Seance>> type = new TypeReference<>() {};
            Map<String, Seance> seanseMap = mapper.readValue(fileReader, type);
            iterateOverACinemaMap(seanseMap);

            System.out.println("Parsing complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void iterateOverACinemaMap(Map<String, Seance> seanseMap) {
        Iterator<String> iterator = seanseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Seance currentSeanse = seanseMap.get(key);
            System.out.println("#" + key + ": " + currentSeanse.name + ", " + currentSeanse.locate);
        }
    }
}
