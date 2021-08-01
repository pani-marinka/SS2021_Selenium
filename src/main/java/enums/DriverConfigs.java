package enums;

public enum DriverConfigs {


    CHROMENAME("webdriver.chrome.driver"),
    FIREFOXNAME("webdriver.gecko.driver"),
    EDGENAME("webdriver.edge.driver"),

    DRIVERDELAYEXECUTION("30"),
    CHROMELOCATION("C:/Users/Maryna/Downloads/chromedriver.exe"),
    FIREFOXLOCATION("FAILED"),
    EDGELOCATION("NOT_FOUND");


    private DriverConfigs(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
