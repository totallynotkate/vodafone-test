package test.kotsiievska.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by totallynotkate on 2020-02-02.
 */
public class MainPage extends BasePage {
    @FindBy(id = "twotabsearchtextbox")
    private HtmlElement searchInput;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get("https://amazon.com");
        return this;
    }

    public void searchForGoods(String searchTerm) {
        searchInput
                .click();
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
    }
}
