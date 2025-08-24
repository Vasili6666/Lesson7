package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponents {

    SelenideElement submittingLabel = $("#example-modal-sizes-title-lg"),
            submittingTable = $(".table-responsive");

    public void checkDataInTable(String label, String value) {
        submittingTable.$(byText(label)).parent().shouldHave(text(value));
    }

    public void checkDataTitle(String value) {
        submittingLabel.shouldHave(text(value));

    }
}
