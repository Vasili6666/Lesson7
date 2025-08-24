package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithMinDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Basil")
                .setLastName("Pupkin")
                .setGender("Male")
                .setUserNumber("0441234567")
                .setEmail("pupkin@basil.com")
                .submit();

       registrationPage.checkResultTitle("Thanks for submitting the form")
                .checkResultCells("Student Name", "Basil Pupkin")
                .checkResultCells("Gender", "Male")
                .checkResultCells("Mobile", "0441234567");

    }
}
