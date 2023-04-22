package refactoring.model.format;

import banksUtil.Monobank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

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
