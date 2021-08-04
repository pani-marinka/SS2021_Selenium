package enums;

public enum DriverConfigs {


    CHROME("webdriver.chrome.driver", "C:/Users/Maryna/Downloads/chromedriver.exe"),    /*!DONE  сделать два параметра*/
    FIREFOX("webdriver.gecko.driver", "path"),
    EDGE("webdriver.edge.driver", "path"),
    DRIVERDELAYEXECUTION("30", "40");



    private DriverConfigs(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    private String value1;
    private String value2;


    public String getValueName() {
        return value1;
    }

    public String getValueLocatin() {
        return value2;
    }

}
