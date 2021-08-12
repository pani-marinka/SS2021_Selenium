package org.example;

import confProperty.ConfProperties;
import dataProviderForTests.DataProviderClass;
import enums.BusinessConfigs;
import enums.LocationConfigs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BlogPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.TrainingListPage;

public class TrainingTests extends BaseTest {


    private SignInPage signInPage;
    private TrainingListPage trainingListPage;
    public BlogPage blogPage;
    private HomePage homePage;

    //    @BeforeClass
    @BeforeMethod
    public void getСreateObj() {
        signInPage = new SignInPage();
        trainingListPage = new TrainingListPage();
        blogPage = new BlogPage();
        homePage = new HomePage();
    }
  // for scenario
    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’: Java and Ruby",
            dataProvider = "numberOfCourses", dataProviderClass = DataProviderClass.class)
    public void searchTrainingCourses(String nameOfCourse1) {
        homePage
                .proceedToHomePage()
                .clickSignInButton()
                .SignIn(ConfProperties.getProperty("login"), ConfProperties.getProperty("passwordCorrect")); //DONE! -- логин та пароль в conf.propetis
        trainingListPage
                .clickTrainingListButton()
                .clickClearLocation() //if visibility for me
                .clickSearchButton()
                .clickBySkills()
                .clickByCheckGeneralCourses(nameOfCourse1)
                .clickSearchButton()
                .verifyCoursesDisplay(nameOfCourse1)
                .clickSearchButton()
                .clickByCheckGeneralCourses(nameOfCourse1);
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
                .verifyLocationUkraineMulti(LocationConfigs.UKRAINE.getValue(), LocationConfigs.MULTILOCATION.getValue());

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
                .verifyListEnumCoursesDisplayed();

    }
}
//