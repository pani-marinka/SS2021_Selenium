package pageObjects;

import enums.BusinessConfigs;
import enums.LocationConfigs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.logging.Logger;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class.getName());
    //field Search at the TrainingList
    private By searchButton = By.cssSelector("input.input-field-search.ng-pristine");
    //field By Locations, By Skils
    private By byLocationSkills = By.cssSelector("div.navigation-item.ng-binding");
    //field By Locations Ukraine
    private By byLocationUkraine = By.xpath("//div[contains(@class,'location__not-active-label') and contains(text(),'Ukr')]");
    private By byClearLocation = By.xpath("//span[@ng-click='clearAllLocations(totalLocationList)']");
    //checkBox Courses General //Java, Ruby
    public By byNames(String courseName) {
        return By.xpath("//label[normalize-space()='" + courseName + "']/span");
    }
    //checkBox Lviv
    private By checkLviv = By.xpath("//label[normalize-space()='Lviv']/span");
    public By byAllDispleyedCourses = By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");
    // all courses Ukr and Multi
    public By byLocationCountries() {
        return By.xpath("//div[contains(@class,'training-list__container')]//*[self::div or self::span][contains(text(), '"+ LocationConfigs.UKRAINE.getValue() +"') or contains(text(), '"+ LocationConfigs.MULTILOCATION.getValue()+"')]");
    }
    // определение локатора кнопки входа в аккаунт
    // defining the locator of the login button
    private By signInButton = By.className("header-auth__signin");
    //TainingList after Login
    private By trainingListButton = By.cssSelector("a.topNavItem.training");


    //base URL Training List
    public TrainingListPage proceedToTrainingPage() {
        proceedToPage(BusinessConfigs.TRAINLISTURL.getValue());
        return this;
    }

    public TrainingListPage clickSignInButton() {
        getElement(signInButton).click();
        return this;
    }

    //assert for courses Java, Ruby
    public TrainingListPage verifyCoursesDisplay(String courseName) {
        ArrayList<WebElement> listCourses = (ArrayList<WebElement>) getElements(byAllDispleyedCourses);
        int tmp = listCourses.size();
        boolean isCourseName = false;
        if (!listCourses.isEmpty()) {
            isCourseName = listCourses.stream()
                    .allMatch((i) -> i.getText().toLowerCase().contains(courseName));
        } else {
            LOG.info(String.format("Courses %s empty ", courseName));
            Assert.assertTrue(isCourseName, " There is empty");
        }
        LOG.info(String.format("Courses is %s ", courseName));
        Assert.assertTrue(isCourseName, "Not everything contains " + courseName);
        return this;
    }

    //amount courses Ukr and Multi
    public TrainingListPage verifyLocationUkraineMulti(String Country, String Multi) {
        ArrayList<WebElement> listLocations = (ArrayList<WebElement>) getElements(byLocationCountries());
        boolean isLocation = false;
        if (!listLocations.isEmpty()) {
            isLocation = listLocations.stream()
                    .allMatch((i) -> i.getText().contains(Country) || i.getText().contains(Multi));
        }
        LOG.info("is " + isLocation);
        Assert.assertTrue(isLocation, " It must true");
        return this;
    }


    public TrainingListPage clickTrainingListButton() {  //  move to TraninListPage
        LOG.info(String.format("Expected Training List!"));
        getElements(trainingListButton).get(1).click();
        LOG.info(String.format("click!"));
        return this;
    }

    public TrainingListPage clickSearchButton() { //  click to Search
        getElement(searchButton).click();
        return this;
    }

    public TrainingListPage clickClearLocation() { //  click to Search
        getElement(byClearLocation).click();
        return this;
    }

    public TrainingListPage clickLocationUkraine() { //  click to Search
        getElement(byLocationUkraine).click();
        return this;
    }

    public TrainingListPage clickBySkills() { // click By Skills
        getElements(byLocationSkills).get(1).click();
        return this;
    }

    public TrainingListPage clickByLocation() { // click By Location
        getElements(byLocationSkills).get(0).click();
        return this;
    }


    public TrainingListPage clickByCheckGeneralCourses(String nameCourses) {  //click checkBox Java,Ruby
        //   int tmp = getElements(byNames(nameCourses)).size(); //for test
        getElements(byNames(nameCourses)).get(0).click();// check  Java check - 0 elementsOfListsWebElments
        return this;
    }


    public TrainingListPage clickBycheckLviv() {  //click checkBox Lviv
     //   int tmp = getElements(checkLviv).size(); //for test
        getElements(checkLviv).get(0).click();// check Lviv(0 from ListElments)
        return this;
    }


}
//