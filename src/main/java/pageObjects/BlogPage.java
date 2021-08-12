package pageObjects;


import enums.NameOfCoursesConfig;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class BlogPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class.getName());

    //search link BLOG
    private By blogListButton = By.cssSelector("a.topNavItem.news");
    //get Links:  News   REAL STORIES MATERIALS HARD SKILLS  SOFT SKILLS EVENTS
    private By listLinks = By.cssSelector("a.tab-nav__item.ng-scope");

    public By linkFromBlog(String nameLink) {
        return By.xpath("//span[@class='ng-binding' and contains(text(),'" + nameLink + "')]");
    }

    // click to TraninListPage
    public BlogPage clickBlogListButton() {
        // int tmp = getElements(blogListButton).size(); // for test
        getElements(blogListButton).get(1).click();
        return this;
    }


    //  Links displayed from Web
    public BlogPage verifyListLinksDisplayed(String link) {
        LOG.info(String.format("Expected link %s", link));
        Assert.assertEquals(isDisplayed(linkFromBlog(link)), true);
        LOG.info(String.format("is Enabled"));
        return this;
    }

    public BlogPage verifyListEnumCoursesDisplayed() {
              for(Enum enam: NameOfCoursesConfig.values()) {
            String link = enam.toString();
            LOG.info(String.format("Expected link %s", link));
            Assert.assertEquals(isDisplayed(linkFromBlog(link)), true);
            LOG.info(String.format("is Enabled"));
        }
        return this;
    }


}
//