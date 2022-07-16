package Settings;

public enum NumberOfDecimalPlaces {
    TWO (2),
    THREE (3),
    FOUR (4);

    private int intNumber;

    NumberOfDecimalPlaces(int intNumber) {
        this.intNumber = intNumber;
    }

    public int getIntNumber() {
        return intNumber;
    }

    public void setIntNumber(int intNumber) {
        this.intNumber = intNumber;
    }
}
