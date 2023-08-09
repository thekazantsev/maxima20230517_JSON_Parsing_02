import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pojo.cinema.Seanse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

public class GsonParserSeanse {
    public static void main(String[] args) {
        String seanseJsonFile = "src/main/resources/Cinema.json";
        String charset = "UTF-8";

        try (FileReader fileReader = new FileReader(seanseJsonFile, Charset.forName(charset));) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Seanse>>(){}.getType();
            Map<String, Seanse> seanseMap = gson.fromJson(fileReader, type);
            iterateOverACinemaMap(seanseMap);

            System.out.println("Parsing complete");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void iterateOverACinemaMap(Map<String, Seanse> seanseMap) {
        Iterator<String> iterator = seanseMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Seanse currentSeanse = seanseMap.get(key);
            System.out.println("#" + key + ": " + currentSeanse.name + ", " + currentSeanse.locate);
        }
    }

}
