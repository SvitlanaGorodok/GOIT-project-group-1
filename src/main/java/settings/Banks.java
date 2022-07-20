package settings;

public enum Banks {
    PRIVAT("Privat"),
    MONO("Monobank"),
    NBU("NBU");

    private String bankName;

    Banks(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
