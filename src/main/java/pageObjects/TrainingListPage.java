package pageObjects;

import enums.BusinessConfigs;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TrainingListPage extends AbstractPage {

    //field Search at the TrainingList
    private By searchButton = By.cssSelector("input.input-field-search.ng-pristine");

  //field By Skils
    private By bySkills = By.cssSelector("div.navigation-item.ng-binding");

    //checkBox Ruby
    private By checkRuby = By.xpath("//label[normalize-space()='Ruby']/span");

    //checkBox Java
    private By checkJava = By.xpath("//label[normalize-space()='Java']/span");


   //amount Java courses with word Java
    private By amountJava = By.xpath("//div[@class='training-list__container training-list__desktop']//div[contains(text(), 'Java')]");

    //amount Java courses with word Ruby
    private By amountRuby = By.xpath("//div[@class='training-list__container training-list__desktop']//div[contains(text(), 'Ruby')]");

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

//amount List size Ruby
    public int amountRubyCourses(){
        int tmp = getElements(amountRuby).size();
        return getElements(amountRuby).size();
    }

//amount List size Java
    public int amountJavaCourses(){
       int tmp = getElements(amountJava).size();
        return getElements(amountJava).size();
    }

    //assert Java courses
    public void verifyAmountCoursesJavaDisplayed() {
        Assert.assertEquals(amountJavaCourses(),7, "Java + Belarus == 7  or Generaly 17 + 1(without word Java)");
    }

    //assert Ruby courses
    public void verifyAmountCoursesRubyDisplayed() {
        Assert.assertEquals(amountRubyCourses(),0, "Ruby == 0");
    }


    public TrainingListPage clickTrainingListButton() {  //  move to TraninListPage
    // getElement(trainingListButton).click(); // for test
        int tmp = getElements(trainingListButton).size();
        getElements(trainingListButton).get(1).click();
        return new TrainingListPage();
    }

    public TrainingListPage clickSearchButton() { //  click to Search
        getElement(searchButton).click();
        return this;
    }

    public TrainingListPage clickBySkills() { // click By Skills
        getElements(bySkills).get(1).click();
        return this;
    }

    public TrainingListPage clickBycheckJava() {  //click checkBox Java
        int tmp = getElements(checkJava).size();
        getElements(checkJava).get(0).click();// check java(list - Java check - 0)
        return this;
    }

    public TrainingListPage clickBycheckRuby() { //click checkBox Ruby
        int tmp = getElements(checkRuby).size();
        getElements(checkRuby).get(0).click();// check java(list - Java check - 0)
        return this;
    }

    public SignInPage clickSignInButton() {

            getElement(signInButton).click();
            return new SignInPage();
        }

}
