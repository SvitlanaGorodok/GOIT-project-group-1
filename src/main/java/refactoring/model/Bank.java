package refactoring.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Bank {
    private CurrencyPair usd;
    private CurrencyPair eur;
    private CurrencyPair pln;
    private LocalDateTime time;
}
