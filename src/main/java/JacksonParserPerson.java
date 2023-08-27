import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.person.Person;
import pojo.person.Phones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class JacksonParserPerson {

    public static void main(String[] args) {
        File file = Path.of("src", "main", "resources", "Person.json").toFile();

        try {
            ObjectMapper mapper = new ObjectMapper();
            Person person = mapper.readValue(file, Person.class);

            System.out.println("My name: " + person.firstName + " " + person.lastName + " and my friends are: ");
            for (Person friend : person.friends) {
                System.out.print(friend.lastName);
                for (Phones phone : friend.phoneNumbers) {
                    System.out.println(" - phone type: " + phone.type + ", phone number : " + phone.number);
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
