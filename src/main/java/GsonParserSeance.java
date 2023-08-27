import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pojo.cinema.Seance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;

public class GsonParserSeance {
    public static void main(String[] args) {
        File file = Path.of("src", "main", "resources", "Cinema.json").toFile();
        String charset = "UTF-8";

        try (FileReader fileReader = new FileReader(file, Charset.forName(charset));) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Seance>>(){}.getType();
            Map<String, Seance> seanseMap = gson.fromJson(fileReader, type);
            iterateOverACinemaMap(seanseMap);

            System.out.println("Parsing complete");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
