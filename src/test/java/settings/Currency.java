package settings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Currency {


    USD ("USD", true),
    EUR ("EUR", false),
    PLN ("PLN", false),
    BTC ("BTC", false);

    public static boolean USD_selected = true;
    public static boolean EUR_selected = true;


    Currency(String currency, boolean select) {

    }



    public  static String getSelectedCurrensy() {
        List selected = new ArrayList<>();
        if (USD_selected) {
            selected.add("USD");
        }
        if (EUR_selected) {
            selected.add("EUR");
        }

        String result = selected.stream().collect(Collectors.joining(", ", "(", ")")).toString();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getSelectedCurrensy());
    }
}


