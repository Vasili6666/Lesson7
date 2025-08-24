package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistretionWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
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


        registrationPage.checkResultTitle("Thanks for submitting the form")
                .checkResultCells("Student Name", "Basil Pupkin")
                .checkResultCells("Student Email", "pupkin@basil.com")
                .checkResultCells("Gender", "Male")
                .checkResultCells("Mobile", "0441234567")
                .checkResultCells("Date of Birth", "06 February,1982")
                .checkResultCells("Subjects", "Biology")
                .checkResultCells("Hobbies", "Sports")
                .checkResultCells("Picture", "Foto 07.2024.jpg")
                .checkResultCells("Address", "Площадь Пушкина, пр-д Калатушкина, 6")
                .checkResultCells("State and City", "Haryana Karnal");

    }
}
