package tests;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"), // посмотреть правильный локкаторы у Васенкова, и проверь свои!!!!!
                            lastNameInput = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            genderWrapper = $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            calendarInput = $("#dateOfBirthInput"),
                            subjectsInput = $("#subjectsInput"),
                            hobbiesInput =  $("#hobbiesWrapper"),
                            pictureUpload = $("#uploadPicture"),
                            addressInput = $("#currentAddress"),
                            stateInputForClicking = $("#state"),
                            stateCityInput =$("#stateCity-wrapper"),
                            cityInputForClicking = $("#city"),
                            clickSubmit = $("#submit");



        CalendarComponent calendarComponent = new CalendarComponent();
        TableComponents tableComponents = new TableComponents();



    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanners(){

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month,year);
        return this;
    }
    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;

    }
    public RegistrationPage uploadAttachment(String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInputForClicking.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInputForClicking.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }
    public void submit() {
        clickSubmit.click();


       // sleep(10000);

    }


    // checking Option 1
    public RegistrationPage checkResultTitle(String value) {
        tableComponents.checkDataTitle(value);
        return this;
    }

    public RegistrationPage checkResultCells(String label, String value) {
        tableComponents.checkDataInTable(label, value);
        return this;
    }

    /* checking Option 2

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    return this;
    }
*/
}
