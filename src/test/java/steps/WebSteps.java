package steps;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    //сюда выносить неправильно
    private String  url = "https://github.com/",
            repName = "Wolary/hw4",
            userName = "Wolary",
            findValue = "Issues";

    @Step ("Открываем страницу")
    public void openPage() {
        open(url);
    }

    @Step ("Открываем репозиторий пользователя")
    public void openRepository() {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repName).pressEnter();
        $(".repo-list-item").$(byText(userName)).click();
    }

    @Step("Проверяем существование Issues")
    public void searchIssues() {
        $(".js-repo-nav").shouldHave(text(findValue));
        $(".js-repo-nav").$(byText(findValue)).click();
    }

    @Step("Проверяем что открывается Issues")
    public void checkIssues() {
        $(".repository-content").shouldHave(text("Welcome to issues!"));
    }
}
