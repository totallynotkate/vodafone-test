package test.kotsiievska.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by totallynotkate on 2020-02-03.
 */
public class SearchResultItem extends HtmlElement {
    @FindBy(css = ".a-price[data-a-color='base']")
    private HtmlElement basicPrice;

    @FindBy(css = ".a-color-secondary .a-color-base")
    private HtmlElement alternativePrice;

    @FindBy(css = ".a-size-medium")
    private HtmlElement name;

    public Double getBasicPrice() {
        return parsePrice(basicPrice);
    }

    public Double getAlternativePrice() {
        return parsePrice(alternativePrice);
    }

    public String getName() {
        return name.getText();
    }

    private Double parsePrice(HtmlElement priceElement) {
        try {
            return Double.parseDouble(priceElement.getText().replace("$", "").replace("\n", "."));
        } catch (NumberFormatException | NullPointerException | NoSuchElementException e) {
            return null;
        }
    }
}