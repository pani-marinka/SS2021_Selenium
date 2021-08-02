package org.example;

import confProperty.ConfProperties;
import org.testng.annotations.Test;
import pageObjects.BlogPage;
import pageObjects.HomeBO;
import pageObjects.SignInPage;
import pageObjects.TrainingListPage;

public class TrainingTests extends BaseTest {
    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’: Java and Ruby")
    public void searchTrainingJavaRuby() {
        SignInPage signInPage = new SignInPage();
        HomeBO homeBO = new HomeBO();
        TrainingListPage trainingListPage = new TrainingListPage();

        homeBO
                .proceedToHomePage()
                .clickSignInButton();
        signInPage
                .enterEmail(ConfProperties.getProperty("login"))
                .clickSignInContinue()
                .enterPassword(ConfProperties.getProperty("passwordCorrect")) //Testepam123
                .clickSignInButtonOnPassword();
        trainingListPage
                .clickTrainingListButton()        //.proceedToTrainingPage()
                .clickSearchButton()
                .clickBySkills()
                .clickBycheckJava()
                .verifyAmountCoursesJavaDisplayed();
        trainingListPage
                .clickBycheckJava()
                .clickBycheckRuby()
                .verifyAmountCoursesRubyDisplayed();

    }


    @Test(description = "Verify links on BlogPage")
    public void checkLinksBlog() {
        SignInPage signInPage = new SignInPage();
        BlogPage blogPage = new BlogPage();
        TrainingListPage trainingListPage = new TrainingListPage();

        trainingListPage
                .proceedToTrainingPage()
                .clickSignInButton();
        signInPage
                .enterEmail(ConfProperties.getProperty("login"))
                .clickSignInContinue()
                .enterPassword(ConfProperties.getProperty("passwordCorrect")) //Testepam123
                .clickSignInButtonOnPassword();
        blogPage
                .clickBlogListButton()        //
                .verifylistLinksDisplayed(); //check links displayed


    }

}
