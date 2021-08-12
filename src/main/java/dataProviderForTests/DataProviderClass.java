package dataProviderForTests;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
//
    @DataProvider(name = "linksFromBlog")
    public Object[][] getLinksFromBlogPage() {
        return new Object[][]{
                {"REAL STORIES"},{"NEWS"}, {"MATERIALS"}, {"HARD SKILLS"}, {"SOFT SKILLS"}, {"EVENTS"}};
    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataMethod() {
        return new Object[][]{{"testepammail"}, {"@test.com"}, {"testmail@testcom"}, {"testepammail@ukr.netnetnetne"}};
    }

    @DataProvider(name = "loginPasswordCorrect")
    public Object[][] getCorrectData() {
        return new Object[][]{
                {"testepammail@ukr.net", "Testepam123"}};
    }

    @DataProvider(name = "loginPasswordIncorrect")
    public Object[][] getIncorrectData() {
        return new Object[][]{
                {"testepammail@ukr.net", "incorrect"}};
    }
    @DataProvider(name = "loginBoundaryCorrectData")
    public Object[][] getLoginBoundaryCorrectData() {
        return new Object[][]{
                {"testepammail@ukr.Aakunamata"}};
    }

    @DataProvider(name = "numberOfCourses")
    public Object[][] getNumberOfCourses() {
        return new Object[][]{
                { "Java" }, {"Ruby"}};
    }

    @DataProvider(name = "numberOfCourses2")
    public Object[][] getNumberOfCourses2() {
        return new Object[][]{
                { "Java"} , {"Ruby"}};
    }

}

