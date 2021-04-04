package steps;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тест с аннотациями")

public class AnnotatedSteps {
    private WebSteps steps = new WebSteps();

    @Test
    @Owner("Nemond")
    @Feature("Работа с разметкой")
    @Story("Разметка аннотаций")
    @Severity(SeverityLevel.BLOCKER)
    @Link (name = "Сайт", url = "https://github.com/")
    @DisplayName("Пример теста")
        public void testSearch () {
        steps.openPage();
        steps.openRepository();
        steps.searchIssues();
        steps.checkIssues();
    }
}
