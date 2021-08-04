package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BlogPageTest extends AbstractPage {


    //search link BLOG
    private By blogListButton = By.cssSelector("a.topNavItem.news");

    //$x("//header/div/div/nav/ul/li/a[contains(@class,'topNavItem news')]")

    //get Links:  News   REAL STORIES MATERIALS HARD SKILLS  SOFT SKILLS EVENTS
    private By listLinks = By.cssSelector("a.tab-nav__item.ng-scope");
    //  $x("//a[contains(@class,'tab-nav__item ng-scope')]")


    // click to TraninListPage
    public BlogPageTest clickBlogListButton() {
        // int tmp = getElements(blogListButton).size(); // for test
        getElements(blogListButton).get(1).click();
        return this;
    }
    //  amount Links(from scenario) on the Blog
    public int amounlistLinks() {
        //  int tmp = getElements(listLinks).size(); //for test
        return getElements(listLinks).size();
    }

    // sum Links displayed from Web
    public void verifyListLinksDisplayed(int amountActiveLinks) {
        int active = 0; // get links displayed from Web
        if (amounlistLinks() == amountActiveLinks) { //check amount active href
            for (WebElement webElement:getElements(listLinks)) {
                if (webElement.isDisplayed()) active++; //check on Displayed
            }
        }
        Assert.assertEquals(active, amountActiveLinks);
    }


}
