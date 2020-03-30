package enums;


public enum DataUser {

    NAME("Roman"),
    LAST_NAME("Poznanenko"),
    EMAIL("poznanenko@gmail.com"),
    BIRTH_DAY("25"),
    BIRTH_MONTH("апреля"),
    BIRTH_YEAR("1993"),
    PHONE_NUMBER("0690912836");


    private final String value;

    DataUser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

