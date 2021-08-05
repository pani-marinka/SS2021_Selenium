package enums;

public enum BusinessConfigs {
    BASEURL("https://training.by/#!/Home?lang=en"),
    TRAINLISTURL("https://training.by/#!/TrainingList?lang=en"),
    BLOGURL("https://training.by/#!/News/Category/news?lang=en"),
    REALSTORIES("REAL STORIES"),
    NEWS("NEWS"),
    MATERIALS("MATERIALS"),
    HARDSKILLS("HARD SKILLS"),
    SOFTSKILLS("SOFT SKILLS"),
    EVENTS("EVENTS"),
    JAVA("Java"),
    RUBY("Ruby"),
    INCORRECTLOGIN1("testepammail"),
    INCORRECTLOGIN2("@test.com"),
    INCORRECTLOGIN3("testmail@testcom"),
    INCORRECTLOGIN4("testepammail@ukr.netnetnetne"),
    CORRECTLOGIN("testepammail@ukr.net"),
    UKRAINE ("Ukraine"),
    MULTILOCATION("Multi-location");



    private BusinessConfigs(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
