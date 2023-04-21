package refactoring.bank;

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
    private float USD_buy = 0.0f;
    private float USD_sell = 0.0f;
    private float EUR_buy = 0.0f;
    private float EUR_sell = 0.0f;
    private float PLN_buy = 0.0f;
    private float PLN_sell = 0.0f;
    private float BTC_buy = 0.0f;
    private float BTC_sell = 0.0f;
    private LocalDateTime time;
    private String URL;
}
