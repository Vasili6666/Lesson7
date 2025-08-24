package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistretionWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Basil")
                .setLastName("Pupkin")
                .setEmail("pupkin@basil.com")
                .setGender("Male")
                .setUserNumber("0441234567")
                .setDateOfBirth("06", "February", "1982")
                .setSubjectsInput("Biology")
                .setHobbies("Sports")
                .uploadAttachment("Foto 07.2024.jpg")
                .setAddress("Площадь Пушкина, пр-д Калатушкина, 6")
                .setState("Haryana")
                .setCity("Karnal")
                .submit();


             registrationPage.checkResult("Student Name", "Basil Pupkin")
                .checkResult("Student Email", "pupkin@basil.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0441234567")
                .checkResult("Date of Birth", "06 February,1982")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Foto 07.2024.jpg")
                .checkResult("Address", "Площадь Пушкина, пр-д Калатушкина, 6")
                .checkResult("State and City", "Haryana Karnal");

    }
}
