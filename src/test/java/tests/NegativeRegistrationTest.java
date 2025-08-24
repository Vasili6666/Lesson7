package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class NegativeRegistrationTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
        @Test
        void noDataRegistration() {
            registrationPage
                    .openPage()
                    .removeBanners()
                    .submit();

            registrationPage
                    .checkColorOfFirstName("#dc3545 ");

        }

}
