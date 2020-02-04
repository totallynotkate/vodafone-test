package test.kotsiievska;

import org.junit.Test;
import test.kotsiievska.pages.MainPage;
import test.kotsiievska.pages.SearchResultItem;
import test.kotsiievska.pages.SearchResultPage;

import java.util.List;

public class AppTest extends WebTest {
    /**
     * Кейс:
     * 1. открыть страницу https://www.amazon.com/
     * 2. в поисковике ввести phones
     * 3. выбрать чекбокс Apple
     * 4. перейти на 5-ую страницу результатов поиска
     * 5. вывести в консоль названия телефонов с ценой ниже 200$
     */
    @Test
    public void shouldFindAppleProductsUnder200$() {
        String searchTerm = "phones";

        MainPage mainPage = new MainPage(driver);
        mainPage.open().
                searchForGoods(searchTerm);

        SearchResultPage searchResults = new SearchResultPage(driver);
        searchResults
                .clickBrandCheckbox("Apple")
                .goToResultPageWithMouseClicks(5);

        List<SearchResultItem> searchResultItems = searchResults.searchResultBlocks();

        for (SearchResultItem item : searchResultItems) {
            if ((item.getBasicPrice() != null && item.getBasicPrice() < 200)
                    || (item.getAlternativePrice() != null && item.getAlternativePrice() < 200)) {
                System.out.println(item.getName());
            }
        }
    }
}
