package enums;

public enum BusinessConfigs {
    BASEURL("https://training.by/#!/Home?lang=en"),
    HOMEPAGEURL("URLFAILED");



    private BusinessConfigs(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
