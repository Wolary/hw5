package selenide;

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

    @Test
    void githubTest() {

        //открываем страницу
        open("https://github.com/");

        //заходим в репозиторий
        $(".header-search-input").click();
        $(".header-search-input").setValue("Wolary/hw4").pressEnter();
        $(".repo-list-item").$(byText("Wolary")).click();

        //ищем Issues
        $(".js-repo-nav").shouldHave(text("Issues"));
        $(".js-repo-nav").$(byText("Issues")).click();


        //Заходим в Issues и проверяем что они открылись
        $(".repository-content").shouldHave(text("Welcome to issues!"));

        sleep(3000);

    }

}
