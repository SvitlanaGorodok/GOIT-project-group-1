package settings;

public enum Banks {
    PRIVATE("ПриватБанк", "Private"),
    MONO("МоноБанк", "Monobank"),
    NBU("НБУ", "NBU");

    private String bankNameUA;

    private String bankNameEN;

    Banks(String bankNameUA, String bankNameEN) {
        this.bankNameUA = bankNameUA;
        this.bankNameEN = bankNameEN;
    }

    public String getBankNameEN() {
        return bankNameEN;
    }

    public void setBankNameEN(String bankNameEN) {
        this.bankNameEN = bankNameEN;
    }

    public String getBankNameUA() {
        return bankNameUA;
    }

    public void setBankNameUA(String bankNameUA) {
        this.bankNameUA = bankNameUA;
    }
}
