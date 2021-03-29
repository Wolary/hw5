package lambda;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    private String  url = "https://github.com/",
                    repName = "Wolary/hw4",
                    userName = "Wolary",
                    findValue = "Issues";
    @Test
    void githubTest() {

        //открываем страницу
        open(url);

        //заходим в репозиторий
        $(".header-search-input").click();
        $(".header-search-input").setValue(repName).pressEnter();
        $(".repo-list-item").$(byText(userName)).click();

        //ищем Issues
        $(".js-repo-nav").shouldHave(text(findValue));
        $(".js-repo-nav").$(byText(findValue)).click();


        //Заходим в Issues и проверяем что они открылись
        $(".repository-content").shouldHave(text("Welcome to issues!"));

        sleep(3000);

    }

}
