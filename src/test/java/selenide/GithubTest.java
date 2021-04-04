package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {
    private String  url = "https://github.com/",
            repName = "Wolary/hw4",
            userName = "Wolary",
            findValue = "Issues";

    private String url = "https://github.com/",
            repName = "Wolary/hw4",
            userName = "Wolary",
            findValue = "Issues";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void githubTest() {
        open(url);
      
        $(".header-search-input").click();
        $(".header-search-input").setValue(repName).pressEnter();
        $(".repo-list-item").$(byText(userName)).click();
        $(".js-repo-nav").shouldHave(text(findValue));
        $(".js-repo-nav").$(byText(findValue)).click();

        $(".repository-content").shouldHave(text("Welcome to issues!"));
    }
}
