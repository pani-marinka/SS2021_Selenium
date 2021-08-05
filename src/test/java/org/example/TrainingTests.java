package org.example;

import confProperty.ConfProperties;
import dataProviderForTests.DataProviderClass;
import enums.BusinessConfigs;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

public class TrainingTests extends BaseTest {


    private SignInPage signInPage;
    private TrainingListPage trainingListPage;
    public BlogPage blogPage;
    private HomePage homePage;

    @BeforeClass
    public void getСreateObj() {
        // DONE!  один объект for class
        signInPage = new SignInPage();
        trainingListPage = new TrainingListPage();
        blogPage = new BlogPage();
        homePage = new HomePage();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’: Java and Ruby",
            dataProvider = "numberOfCourses", dataProviderClass = DataProviderClass.class)
    public void searchTrainingJavaRuby(String NameOfJava , String NameOfRuby) {
        homePage
                .proceedToHomePage()
                .clickSignInButton()
                .SignIn(ConfProperties.getProperty("login"), ConfProperties.getProperty("passwordCorrect")); //DONE! -- логин та пароль в conf.propetis
        trainingListPage
                .clickTrainingListButton()
                .clickClearLocation() //if visibility for me
                .clickSearchButton()
                .clickBySkills()
                .clickByCheckGeneralCourses(NameOfJava)
                .clickSearchButton()
                .verifyCoursesJavaRuby(NameOfJava)   //DONE!  вертати trainingPage //
                .clickSearchButton()
                .clickByCheckGeneralCourses(NameOfRuby);
    }



    //for example DataProvider
    @Test(description = "Verify links on BlogPage",
            dataProvider = "linksFromBlog", dataProviderClass = DataProviderClass.class)
    public void checkLinksBlog(String data) {
        trainingListPage
                .proceedToTrainingPage()
                .clickSignInButton();
        signInPage
                .SignIn(ConfProperties.getProperty("login"), ConfProperties.getProperty("passwordCorrect"));
        blogPage
                .clickBlogListButton()
                .verifyListLinksDisplayed(data);
    }

    //for example Enum
    @Test(description = "Verify links on BlogPage2")
    public void checkLinksBlog2() {
        trainingListPage
                .proceedToTrainingPage()
                .clickSignInButton();
        signInPage
                .SignIn(ConfProperties.getProperty("login"), ConfProperties.getProperty("passwordCorrect"));
        blogPage
                .clickBlogListButton()
                .verifyListLinksDisplayed(BusinessConfigs.NEWS.getValue())
                .verifyListLinksDisplayed(BusinessConfigs.REALSTORIES.getValue())
                .verifyListLinksDisplayed(BusinessConfigs.MATERIALS.getValue())
                .verifyListLinksDisplayed(BusinessConfigs.HARDSKILLS.getValue())
                .verifyListLinksDisplayed(BusinessConfigs.SOFTSKILLS.getValue())
                .verifyListLinksDisplayed(BusinessConfigs.EVENTS.getValue());

    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Location’: Lviv : only Ukraine and MultiLocation")
    public void checkLocation() {
        trainingListPage
                .proceedToTrainingPage()
                .clickSignInButton();
        signInPage
                .SignIn(ConfProperties.getProperty("login"), ConfProperties.getProperty("passwordCorrect"));
        trainingListPage
                .clickTrainingListButton()
                .clickClearLocation()
                .clickSearchButton()
                .clickByLocation()
                .clickLocationUkraine()
                .clickBycheckLviv()
                .clickByLocation() //visible for me
                .verifyLocationUkraineMulti();

    }

}
