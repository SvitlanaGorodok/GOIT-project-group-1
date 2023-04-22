package refactoring.model.jsonformat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// View of currency values in json format for Monobank
@Setter
@Getter
@ToString
public class FormatMono extends Format {
        private int currencyCodeA;
        private int currencyCodeB;
        private int date;
        private float rateBuy;
        private float rateSell;
        private float rateCross;
}
