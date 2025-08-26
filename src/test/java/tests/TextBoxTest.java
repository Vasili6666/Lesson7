package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillTextBoxTest() {
        textBoxPage.openPage()
                .removeBanners()
                .setFullName("Maximus")
                .setEmailInput("maximus@general.it")
                .setCurrentAddressInput("Province Of Spain")
                .setPermanentAddressInput("Roman Empire")
                .submit();


        textBoxPage.checkResult("Name:Maximus\nEmail:maximus@general.it\n" +
                "Current Address :Province Of Spain\nPermananet Address :Roman Empire");

    }


}
