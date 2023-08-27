import com.google.gson.Gson;
import pojo.person.Person;
import pojo.person.Phones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class GsonParserPerson {
    public static void main(String[] args) {
        File file = Path.of("src", "main", "resources", "Person.json").toFile();

        try (FileReader fileReader = new FileReader(file);) {
            Gson gson = new Gson();
            Person person = gson.fromJson(fileReader, Person.class);

            System.out.println("My name: " + person.firstName + " " + person.lastName + " and my friends are: ");
            for (Person friend : person.friends) {
                System.out.println(friend.lastName);
                for (Phones phone : friend.phoneNumbers) {
                    System.out.println(" - phone type: " + phone.type + ", number : " + phone.number);
                }
                System.out.println(friend.address.streetAddress + ", " + friend.address.city);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
