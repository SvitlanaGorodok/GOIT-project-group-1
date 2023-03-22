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
    private Float USD_buy = 0.0f;
    private Float USD_sell = 0.0f;
    private Float EUR_buy = 0.0f;
    private Float EUR_sell = 0.0f;
    private Float PLN_buy = 0.0f;
    private Float PLN_sell = 0.0f;
    private Float BTC_buy = 0.0f;
    private Float BTC_sell = 0.0f;
    private LocalDateTime time;
    private String URL;
}
