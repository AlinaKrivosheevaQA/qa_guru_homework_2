package selenide;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SearchJUnit5CodeInSelenideWiki {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void searchJUnit5CodeTest() {

        open("/selenide/selenide");
        $("ul.UnderlineNav-body li.d-inline-flex a#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("div#wiki-content").shouldHave(text("2. Using JUnit4 just describe rule inside test class:"));

    }
}
