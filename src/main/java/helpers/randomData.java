package helpers;

import com.github.javafaker.Faker;

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
    public static String getCity() { return faker.address().cityName();}
    public static String getDescription() {
        return faker.lorem().sentence();
    }
    public static String generateFakeUUID() {
        return UUID.randomUUID().toString();
    }
}