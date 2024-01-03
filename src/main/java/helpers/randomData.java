package com.shidqiadiatma.helpers;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @author Shidqi Adiatma a.k.a. hipstertester on 07/12/23
 * @project secondhand-web-selenium-cucumber
 */

public class randomData {

    static List<String> indexList = Arrays.asList("1", "2", "3", "4", "5");
    static Random random = new Random();
    static Faker faker = new Faker(new Locale("ID"));

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getFullName() {
        return faker.name().fullName();
    }
    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getValue() {
        return indexList.get(random.nextInt(indexList.size()));
    }
    public static String getProductName() {
        return faker.commerce().productName();
    }

    public static String getProductPrice() {
        return faker.commerce().price();
    }

    public static String getDescription() {
        return faker.lorem().sentence();
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String getStreetAddress() {
        return faker.address().streetAddress();
    }
}