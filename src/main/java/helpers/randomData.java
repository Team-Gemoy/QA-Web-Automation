package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class randomData {

    static Faker faker = new Faker(new Locale("ID"));

    public static String getFullName() {
        return faker.name().fullName();
    }
    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getNationality() {
        return faker.country().name();
    }
    public static String getEmail() {
        return faker.internet().emailAddress();
    }

//    public static String getEmail() {
//        String email = "";
//        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
//        String temp = RandomStringUtils.random(30, allowedChars);
//        email = temp.substring(0, temp.length() - 9) + "@gmail.com";
//        return email;
//    }
    public static String getCity() { return faker.address().cityName();}
    public static String getDescription() {
        return faker.lorem().sentence();
    }
    public static String generateFakeUUID() {
        return UUID.randomUUID().toString();
    }
}