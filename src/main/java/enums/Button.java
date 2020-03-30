package enums;

public enum Button {

    CAREER("Карьера"),
    WANT_TO_WORK_IN_NETPEAK("Я хочу работать в Netpeak"),
    SEND_CV("Отправить анкету");

    private final String buton;

    public String getButon() {
        return buton;
    }

    Button(String buton) {
        this.buton = buton;
    }
}
