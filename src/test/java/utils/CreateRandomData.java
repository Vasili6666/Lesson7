package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;


public class CreateRandomData {

    static Faker faker = new Faker(new Locale("en-GB"));
    static Random random = new Random();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getBirthMonth() {

        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public static String getBirthYear() {
        return String.valueOf(faker.number().numberBetween(1950, 2005));
    }

    public static String getBirthDay(String month) {
        int maxDays;
        switch (month) {
            case "February":
                maxDays = 28;
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                maxDays = 30;
                break;
            default:
                maxDays = 31;
        }
        return String.valueOf(faker.number().numberBetween(1, maxDays + 1));
    }

    public static String getSubjects() {

        return faker.options().option("Biology", "Chemistry", "Physics", "Maths", "English",
                "Computer Science", "Economics", "Arts", "History");
    }

    public static String getHobbies() {

        return faker.options().option("Sports", "Reading", "Music");

    }

    public static String getPicture() {

        return faker.options().option("Fish1.jpg", "Fish2.jpg", "Fish3.jpg");
    }

    public static String getAddress() {
        return faker.address().streetAddress() + ", " + faker.address().cityName();
    }

    public static String getState() {

        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getCity(String state) {
        switch (state) {
            case "NCR":

                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":

                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":

                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":

                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return "Unknown";
        }
    }


}
