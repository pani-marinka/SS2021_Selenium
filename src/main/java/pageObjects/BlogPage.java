package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

public class BlogPage extends AbstractPage {
    //blogList after Login
    private By blogListButton = By.cssSelector("a.topNavItem.news");
    //$x("//header/div/div/nav/ul/li/a[contains(@class,'topNavItem news')]")

    //webHref Links News   REAL STORIES MATERIALS HARD SKILLS  SOFT SKILLS EVENTS
    private By listLinks = By.cssSelector("a.tab-nav__item.ng-scope");
    //        $x("//a[contains(@class,'tab-nav__item ng-scope')]")


    public BlogPage clickBlogListButton() {  //  move to TraninListPage
       // int tmp = getElements(blogListButton).size(); // for test
        getElements(blogListButton).get(1).click();
        return new BlogPage();
    }

    public int amounlistLinks() {  //  move to TraninListPage
        //  int tmp = getElements(listLinks).size(); //for test
        return getElements(listLinks).size();
    }

    public void verifylistLinksDisplayed() {
        int active = 0;
        if (amounlistLinks() == 6) { //check amount active href
            for (int i = 0; i < amounlistLinks(); i++) {
                if (getElements(listLinks).get(0).isDisplayed()) active++;
            }
        }

        Assert.assertEquals(active, 6, "active links == 6)");
    }

}
