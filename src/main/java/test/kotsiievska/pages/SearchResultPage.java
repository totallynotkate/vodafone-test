package test.kotsiievska.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by totallynotkate on 2020-02-02.
 */
public class SearchResultPage extends BasePage {
    @FindBy(css = "#brandsRefinements li span.a-list-item")
    private List<HtmlElement> brandCheckboxes;
    @FindBy(css = ".s-search-results .s-result-item")
    private List<SearchResultItem> searchResults;
    @FindBy(css = ".a-pagination li")
    private List<HtmlElement> paginationButtons;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage clickBrandCheckbox(String brand) {
        brandCheckboxes.stream().filter(el -> el.getText().equals(brand)).findAny().get().click();
        return this;
    }

    public SearchResultPage goToResultPageWithMouseClicks(int pagenumber) {
        for (int i = 0; i < pagenumber - 1; i++) {
            HtmlElement nextButton = paginationButtons.stream().filter(el -> el.getText().equals("Next→")).findAny().get();
            nextButton.click();
        }
        return this;
    }

    public List<SearchResultItem> searchResultBlocks() {
        return searchResults;
    }
}
