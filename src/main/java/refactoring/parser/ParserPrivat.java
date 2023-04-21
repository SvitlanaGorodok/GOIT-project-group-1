package refactoring.parser;

import refactoring.bank.Bank;
import refactoring.bank.CurrencyPair;
import refactoring.format.FormatPrivat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserPrivat implements Parser<FormatPrivat> {
    @Override
    public Bank parse(List<FormatPrivat> listOfData) {
        Bank bank = new Bank();
        Map<String, CurrencyPair> map = listOfData.stream()
                .collect(Collectors.toMap(FormatPrivat::getCcy,
                        format -> new CurrencyPair(format.getBuy(), format.getSale())));
        CurrencyPair pair = map.get("USD");
        bank.setUSD_buy(pair.getBuy());
        bank.setUSD_sell(pair.getSell());
        pair = map.get("EUR");
        bank.setEUR_buy(pair.getBuy());
        bank.setEUR_sell(pair.getSell());
        pair = map.get("PLZ");
        bank.setPLN_buy(pair.getBuy());
        bank.setPLN_sell(pair.getSell());
        pair = map.get("BTC");
        bank.setBTC_buy(pair.getBuy());
        bank.setBTC_sell(pair.getSell());
        return bank;
    }


}
