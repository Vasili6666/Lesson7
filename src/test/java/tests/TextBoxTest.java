package tests;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static java.lang.Thread.sleep;


public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillTextBoxTest()  {
        textBoxPage.openPage()
                .removeBanners()
                .setFullName("Maximus")
                .setEmailInput("maximus@general.it")
                .setCurrentAddressInput("Province Of Spain")
                .setPermanentAddressInput("Roman Empire")
                .submit();

        //sleep(5000);


        textBoxPage.checkResult( "Name:Maximus\nEmail:maximus@general.it\n" +
                "Current Address :Province Of Spain\nPermananet Address :Roman Empire");



        /*textBoxPage.checkName("Name:Maximus")
                .checkEmail("Email:maximus@general.it")
                .checkCurrentAddress("Current Address :Province Of Spain")
                .checkPermanentAddress("Permananet Address :Roman Empire");*/
    }


}
