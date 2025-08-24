package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private final SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            clickSubmit = $("#submit"),
            result = $("#output");


    /*resultName = $("#output #name"),
    resultEmail = $("#output #email"),
    resultCurrentAddress =$("#output #currentAddress"),
    resultPermanentAddress =$("#output #permanentAddress");*/


    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddressInput(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public void submit() {
        clickSubmit.click();
    }

    //output
    public void checkResult(String value) {
        result.shouldHave(partialText(value));
    }


    /*public TextBoxPage checkName(String value){
        resultName.shouldHave(partialText(value));
        return this;
    }
    public TextBoxPage checkEmail(String value){
        resultEmail.shouldHave(partialText(value));
        return this;
    }
    public TextBoxPage checkCurrentAddress(String value){
        resultCurrentAddress.shouldHave(text(value));
        return this;
    }
    public void checkPermanentAddress(String value){
        resultPermanentAddress.shouldHave(partialText(value));
    }
*/
}
