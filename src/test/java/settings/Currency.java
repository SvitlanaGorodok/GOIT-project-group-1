package settings;

public enum Currency {
    USD ("USD", true),
    EUR ("EUR", false),
    PLN ("PLN", false),
    BTC ("BTC", false);

    Currency(String currency, boolean select) {
    }



    public String getSelectedCurrensy() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
}
