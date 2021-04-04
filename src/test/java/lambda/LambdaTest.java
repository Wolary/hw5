package lambda;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    private String  url = "https://github.com/",
                    repName = "Wolary/hw4",
                    userName = "Wolary",
                    findValue = "Issues";
    
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void githubTest() {
        step("Открываем сайт", () -> {
            open(url);
        });

        step("Заходим в репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(repName).pressEnter();
            $(".repo-list-item").$(byText(userName)).click();
        });

        step("Ищем и проверяем Issues", () -> {
            $(".js-repo-nav").shouldHave(text(findValue));
            $(".js-repo-nav").$(byText(findValue)).click();
        });

        step("Заходим в Issues и проверяем что они открылись", () -> {
            $(".repository-content").shouldHave(text("Welcome to issues!"));

        });
    }
}
