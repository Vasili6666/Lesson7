package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);

        // Добавляем ведущий ноль для дней < 10
        String formattedDay = day.length() == 1 ? "0" + day : day;
        $(".react-datepicker__day--0" + formattedDay + ":not(.react-datepicker__day--outside-month)").click();
    }

}


