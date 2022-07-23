package serviceClasses;

import settings.Banks;
import settings.Currency;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class CurrencyDataBase {
    public static HashMap<Banks, Bank> currentInfo = new HashMap<>();

    public static Bank getCurrentInfo(Banks bankName) {
        Bank bank = new Bank();
        bank.setBankName(bankName);
        bank.setEUR_buy(1.0f);
        bank.setEUR_sell(1.0f);
        bank.setUSD_buy(1.0f);
        bank.setUSD_sell(1.0f);
        bank.setPLN_buy(1.0f);
        bank.setPLN_sell(1.0f);
        bank.setBTC_buy(1.0f);
        bank.setBTC_sell(1.0f);
        bank.setTime(LocalDateTime.now().plusDays(1));
        return bank;
    }

    public void setCurrentInfo(Banks bankName, Bank bank) {
        currentInfo.put(bankName, bank);
    }

    public Bank getCurrencyRates (Banks bankName){
        Bank bank = currentInfo.get(bankName);
        LocalDateTime currentTime = LocalDateTime.now();
        long timeDiff = Duration.between(LocalDateTime.now(), bank.getTime()).toMinutes();
        if (timeDiff>5){
            setCurrentInfo(bankName, bank);
        }
        return currentInfo.get(bankName);
    }

}
