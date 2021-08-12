package enums;

public enum LocationConfigs {

    UKRAINE("Ukraine"),
    MULTILOCATION("Multi-location");


    private LocationConfigs(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}

//