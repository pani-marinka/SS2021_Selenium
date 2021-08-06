package enums;

public enum LoginConfig {
    INCORRECTLOGIN1("testepammail"),
    INCORRECTLOGIN2("@test.com"),
    INCORRECTLOGIN3("testmail@testcom"),
    CORRECTLOGIN("testepammail@ukr.net"),
    INCORRECTLOGIN4("testepammail@ukr.netnetnetne");

    private String name;

    LoginConfig(String name) {
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