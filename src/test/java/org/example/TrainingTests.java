package org.example;

import dataProviderForTests.DataProviderClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

public class TrainingTests extends BaseTest {


    private SignInPage signInPage;
    private TrainingListPage trainingListPage;
    public BlogPageTest blogPage;
    private HomePage homePage;

    @BeforeClass
    public void getСreateObj() {
       // DONE!  один объект
        signInPage = new SignInPage();
        trainingListPage = new TrainingListPage(); // один объект для класса ()
        blogPage = new BlogPageTest();
        homePage = new HomePage();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’: Java and Ruby",
            dataProvider = "numberOfCourses", dataProviderClass = DataProviderClass.class)
    public void searchTrainingJavaRuby(
            String email, String passwordCorrect,
            String nameOfCorses, String expectedAmount,  //Java  , Expected: "Java + Belarus == 7  or Generaly 17 + 1(without word Java)"
            String nameOfCorses2, String expectedAmount2) //Ruby, Expected == 0
    {
        homePage
                .getUrlHomeClickSignIn()
                .enterEmailPasswordSignIn(email, passwordCorrect);
        trainingListPage
                .clickTrainingListButton()
                .clickClearLocation()
                .clickSearchButton()
                .clickBySkills()
                .clickByCheckGeneralCourses(nameOfCorses)
                .clickSearchButton()
                .verifyAmountCoursesGeneralDisplayed(nameOfCorses, Integer.valueOf(expectedAmount))    //DONE!  вертати trainingPage
                .clickSearchButton()
                .clickByCheckGeneralCourses(nameOfCorses)
                .clickByCheckGeneralCourses(nameOfCorses2)
                .verifyAmountCoursesGeneralDisplayed(nameOfCorses2, Integer.valueOf(expectedAmount2));
    }


    @Test(description = "Verify links on BlogPage",
            dataProvider = "loginPasswordCorrect", dataProviderClass = DataProviderClass.class)
    public void checkLinksBlog(String email, String passwordCorrect) {

        trainingListPage
                .getUrlTrainingSignIn();
        signInPage
                .enterEmailPasswordSignIn(email, passwordCorrect);
        blogPage
                .clickBlogListButton()
                .verifyListLinksDisplayed(6); //expected links displayed 6
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Location’: Lviv : only Ukraine and MultiLocation",
            dataProvider = "loginPasswordCorrect", dataProviderClass = DataProviderClass.class)
    public void checkLocation(String email, String passwordCorrect) {
        trainingListPage
                .getUrlTrainingSignIn();
        signInPage
                .enterEmailPasswordSignIn(email, passwordCorrect);
        trainingListPage
                .clickTrainingListButton()
                .clickClearLocation()
                .clickSearchButton()
                .clickByLocation()
                .clickLocationUkraine()
                .clickBycheckLviv()
                .verifyAllCoursesLocationDisplayed(9) //general courses Ukr,Multi exppected 9
                .verifyAmountCoursesLocationDisplayed("Ukraine", 8) //check me for places search cities
                .verifyAmountCoursesLocationDisplayed("Lviv", 0); // check for scenario
    }

}
