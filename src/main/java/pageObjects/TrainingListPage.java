package pageObjects;

import enums.BusinessConfigs;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class.getName());
    //field Search at the TrainingList
    private By searchButton = By.cssSelector("input.input-field-search.ng-pristine");

    //field By Locations, By Skils
    private By byLocationSkills = By.cssSelector("div.navigation-item.ng-binding");


    //field By Locations Ukraine
    //private By byLocationUkraine = By.cssSelector("div.location__not-active-label.location__location-active-label-country");
    private By byLocationUkraine = By.xpath("//div[contains(@class,'location__not-active-label') and contains(text(),'Ukr')]");

    private By byClearLocation = By.xpath("//span[@ng-click='clearAllLocations(totalLocationList)']");
    /*
    //span[@ng-click='clearAllLocations(totalLocationList)']
     */

    //checkBox Courses General //Java, Ruby
    public By byNames(String courseName) {
        return By.xpath("//label[normalize-space()='" + courseName + "']/span");
    }


    //checkBox Lviv
    private By checkLviv = By.xpath("//label[normalize-space()='Lviv']/span");


    //amount Java courses with word Java
    //  private By amountJava = By.xpath("//div[@class='training-list__container training-list__desktop']//div[contains(text(), 'Java')]");

    //amount Courses General //Java, Ruby
    public By byAmountCourses(String courseName) {
        //return By.xpath("//div[@class='training-list__container training-list__desktop']/div[contains(text(), '" + courseName + "')]");
        return By.xpath("//div[@class='training-list__container training-list__desktop']//div[contains(text(), '" + courseName + "')]");
    }

    //search  for Location Ukr, Lviv
    public By byAmountCoursesLocation(String search) {
        return By.xpath("//div[contains(@class,'training-list__container')]/div/a/div/div/span[contains(text(),'" + search + "')]");
        // return By.xpath("//div[@class='training-list__container']/div/a/div[contains(@class,'training-item__header')]/following-sibling::div/div/span[contains(text(),'"+search+"')]");
    }

    // all courses Ukr and Multi
    public By byAmountCoursesLocationAll() {
        return By.xpath("//div[contains(@class,'training-list__container')]//*[self::div or self::span][contains(text(), 'Ukraine') or contains(text(), 'Multi-location')]");
        // return By.xpath("//div[@class='training-list__container']/div/a/div[contains(@class,'training-item__header')]/following-sibling::div/div/span[contains(text(),'"+search+"')]");
    }
   /*
     //$x("//div[contains(@class,'training-list__container')]//*[self::div or self::span][contains(text(), 'Ukraine') or contains(text(), 'Multi-location')]")
    // Multi - $x("//div[contains(@class,'training-list__container')]//div[contains(text(),'Multi')]") == 1
    //Ukr - /div[contains(@class,'training-list__container')]//span[contains(text(),'Ukr')]") == 8
    // 8 - $x("//div[@class='training-list__container training-list__desktop']/div/a/div[contains(@class,'training-item__header')]/following-sibling::div/div/span[contains(text(),'Ukr')]")
    // 1- multiLocation
  */

    // определение локатора кнопки входа в аккаунт
    // defining the locator of the login button
    private By signInButton = By.className("header-auth__signin");


    //TainingList after Login
    private By trainingListButton = By.cssSelector("a.topNavItem.training");
    //  private By trainingListButton = By.xpath("nav[@class='main-nav']//a[@class='topNavItem training click hover']");
    // private By trainingListButton = By.xpath("//a[contains(@class,'topNavItem training click hover activeItem')]");

    //base URL Training List
    public TrainingListPage proceedToTrainingPage() {
        proceedToPage(BusinessConfigs.TRAINLISTURL.getValue());
        return this;
    }

    public TrainingListPage clickSignInButton() {
        getElement(signInButton).click();
        return this;
    }

    public TrainingListPage getUrlTrainingSignIn() {
        proceedToTrainingPage()
                .clickSignInButton();
        return this;
    }


    //amount List size for Courses           //? location: country,cities
    public int amountGeneralCourses(By by) {
        int tmp = getElements(by).size(); //for test
        return getElements(by).size();
    }

    //assert for courses Java, Ruby
    public TrainingListPage verifyAmountCoursesGeneralDisplayed(String courseName, int amountCourses) {
        Assert.assertEquals(amountGeneralCourses(byAmountCourses(courseName)), amountCourses);
        return this;
    }

    //for Ukr, Lviv
    public TrainingListPage verifyAmountCoursesLocationDisplayed(String courseName, int amountCourses) {
        Assert.assertEquals(amountGeneralCourses(byAmountCoursesLocation(courseName)), amountCourses);
        return this;
    }

    //amount courses Ukr and Multi
    public TrainingListPage verifyAllCoursesLocationDisplayed(int amountCourses) {
        Assert.assertEquals(amountGeneralCourses(byAmountCoursesLocationAll()), amountCourses);
        return this;
    }


    public TrainingListPage clickTrainingListButton() {  //  move to TraninListPage
        // getElement(trainingListButton).click(); // for test
        LOG.info(String.format("Expected Training List!"));
        int tmp = getElements(trainingListButton).size();
        getElements(trainingListButton).get(1).click();
        LOG.info(String.format("click!"));
        return this; //new TrainingListPage();
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

//"//label[normalize-space()='Java']/span"
    public TrainingListPage clickByCheckGeneralCourses(String nameCourses) {  //click checkBox Java,Ruby
     //   int tmp = getElements(byNames(nameCourses)).size(); //for test
        getElements(byNames(nameCourses)).get(0).click();// check java(list - Java check - 0)
        return this;
    }


    public TrainingListPage clickBycheckLviv() {  //click checkBox Lviv
    //    int tmp = getElements(checkLviv).size(); //for test
        getElements(checkLviv).get(0).click();// check Lviv(list: Lviv check - )
        return this;
    }


}
