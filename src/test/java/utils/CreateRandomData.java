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
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[random.nextInt(months.length)];
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
        String[] subjects = {"Biology", "Chemistry", "Physics", "Maths", "English",
                "Computer Science", "Economics", "Arts", "History"};
        return subjects[random.nextInt(subjects.length)];
    }

    public static String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[random.nextInt(hobbies.length)];
    }

    public static String getPicture() {
        String[] pictures = {"Fish1.jpg", "Fish2.jpg", "Fish3.jpg"};
        return pictures[random.nextInt(pictures.length)];
    }

    public static String getAddress() {
        return faker.address().streetAddress() + ", " + faker.address().cityName();
    }

    public static String getState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return states[random.nextInt(states.length)];
    }

    public static String getCity(String state) {
        switch (state) {
            case "NCR":
                String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
                return ncrCities[random.nextInt(ncrCities.length)];
            case "Uttar Pradesh":
                String[] upCities = {"Agra", "Lucknow", "Merrut"};
                return upCities[random.nextInt(upCities.length)];
            case "Haryana":
                String[] haryanaCities = {"Karnal", "Panipat"};
                return haryanaCities[random.nextInt(haryanaCities.length)];
            case "Rajasthan":
                String[] rajasthanCities = {"Jaipur", "Jaiselmer"};
                return rajasthanCities[random.nextInt(rajasthanCities.length)];
            default:
                return "Unknown";
        }
    }


}
