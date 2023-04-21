package newway.bank;

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
    private Double USD_buy = 0.0;
    private Double USD_sell = 0.0;
    private Double EUR_buy = 0.0;
    private Double EUR_sell = 0.0;
    private Double PLN_buy = 0.0;
    private Double PLN_sell = 0.0;
    private Double BTC_buy = 0.0;
    private Double BTC_sell = 0.0;
    private LocalDateTime time;
    private String URL;
}
