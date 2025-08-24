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

        //$("#subjectsInput").setValue("Biology").pressEnter();

       /* $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
*/

        //$("#uploadPicture").uploadFromClasspath("Foto 07.2024.jpg");


        //$("#currentAddress").setValue("Площадь Пушкина, пр-д Калатушкина, 6");

        /*$("#state").scrollTo().shouldBe(interactable).click();
        $$("div[class*='-option']").findBy(text("Haryana")).click();
        $("#city").scrollTo().shouldBe(interactable).click();
        $$("div[class*='-option']").findBy(text("Karnal")).click();
*/
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
                text("alex@egorov.com"), text("1234567890"));
        registrationPage.checkResult("Student Name", "Alex Egorov")
                .checkResult("Student Email", "alex@egorov.com");



    }
}
