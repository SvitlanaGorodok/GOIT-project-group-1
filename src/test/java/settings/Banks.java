package settings;

public enum Banks {
    PRIVATE ("ПриватБанк"),
    MONO ("МоноБанк"),
    NBU ("НБУ");

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
