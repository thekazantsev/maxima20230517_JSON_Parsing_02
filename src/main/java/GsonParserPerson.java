import com.google.gson.Gson;
import pojo.person.Person;
import pojo.person.Phones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParserPerson {
    public static void main(String[] args) {
        String personJsonFile = "src/main/resources/Person.json";

        try (FileReader fileReader = new FileReader(personJsonFile);) {
            Gson gson = new Gson();
            Person person = gson.fromJson(fileReader, Person.class);

            // Фамилии друзей с телефонами и адресами
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
