package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static utils.CreateRandomData.*;


public class RandomDataRegistrationTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    String
            firstName = getFirstName(),
            lastName = getLastName(),
            userEmail = getEmail(),
            gender = getGender(),
            userNumber = getNumber(),
            birthMonth = getBirthMonth(),
            birthDay = getBirthDay(getBirthMonth()),
            birthYear = getBirthYear(),
            subjects = getSubjects(),
            hobbies = getHobbies(),
            picture = getPicture(),
            address = getAddress(),
            state = getState(),
            city = getCity(state);

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubjectsInput(subjects)
                .setHobbies(hobbies)
                .uploadAttachment(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();


        registrationPage.checkResultTitle("Thanks for submitting the form")
                .checkResultCells("Student Name", firstName+" "+lastName)
                .checkResultCells("Student Email", userEmail)
                .checkResultCells("Gender", gender)
                .checkResultCells("Mobile", userNumber)
                .checkResultCells("Date of Birth", (birthDay +" "+birthMonth+","+ birthYear))
                .checkResultCells("Subjects", subjects)
                .checkResultCells("Hobbies",hobbies)
                .checkResultCells("Picture", picture)
                .checkResultCells("Address", address)
                .checkResultCells("State and City",state+" "+city);
    }
}
