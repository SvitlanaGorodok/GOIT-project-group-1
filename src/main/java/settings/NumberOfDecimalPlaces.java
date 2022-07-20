package settings;

public enum NumberOfDecimalPlaces {
    TWO (2, "twoPlaces"),
    THREE (3, "threePlaces"),
    FOUR (4, "fourPlaces");

    private String nameDecPlaces;
    private int intNumber;

    NumberOfDecimalPlaces(int intNumber, String nameDecPlaces) {

        this.intNumber = intNumber;
        this.nameDecPlaces = nameDecPlaces;

    }

    public int getIntNumber() {
        return intNumber;
    }

    public void setIntNumber(int intNumber) {
        this.intNumber = intNumber;
    }

    public String getNameDecPlaces() {
        return nameDecPlaces;
    }

    public void setNameDecPlaces(String nameDecPlaces) {
        this.nameDecPlaces = nameDecPlaces;
    }
}
