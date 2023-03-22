package newway.format;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// View of currency values in json format for Monobank
public class FormatMono extends Format {
        private int currencyCodeA;
        private int currencyCodeB;
        private int date;
        private float rateBuy;
        private float rateSell;
        private float rateCross;
}
