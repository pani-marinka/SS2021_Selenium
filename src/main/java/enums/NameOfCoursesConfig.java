package enums;

public enum NameOfCoursesConfig {
    REALSTORIES("REAL STORIES"),
    NEWS("NEWS"),
    MATERIALS("MATERIALS"),
    HARDSKILLS("HARD SKILLS"),
    SOFTSKILLS("SOFT SKILLS"),
    EVENTS("EVENTS");

    private String name;

    NameOfCoursesConfig(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
//