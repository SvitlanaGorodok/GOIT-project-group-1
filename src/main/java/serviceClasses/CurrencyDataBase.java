package serviceClasses;

import settings.Banks;
import settings.Currency;

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
        bank.setTime(1.0f);
        return bank;
    }

    public void setCurrentInfo(Banks bankName, Bank bank) {
        currentInfo.put(bankName, bank);
    }



    /*
        1) Витягує з мапи значення по ключу для конкретного банку
        2) Зчитує поле Time і:
        2.1) якщо значення <5 хвилин, то вертає користувачеві актуальне значення отримане з мапи
        2.2) якщо значення >5 хвилин, то
             - робить новий запит до конкретного банку
             - записує результат цього запиту в мапу (перезапис даних, викликає метод запису в мапу hashmap Info)
             - вертає користувачеві актуальне значення
    */
}
