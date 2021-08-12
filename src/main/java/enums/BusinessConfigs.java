package enums;

public enum BusinessConfigs {
    BASEURL("https://training.by/#!/Home?lang=en"),
    TRAINLISTURL("https://training.by/#!/TrainingList?lang=en");



    private BusinessConfigs(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
//