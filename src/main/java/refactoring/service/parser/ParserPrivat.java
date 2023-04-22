package refactoring.service.parser;

import refactoring.model.Bank;
import refactoring.model.CurrencyPair;
import refactoring.model.format.FormatPrivat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserPrivat implements Parser<FormatPrivat> {
    @Override
    public Bank parse(List<FormatPrivat> listOfData) {
        Bank bank = new Bank();
        Map<String, CurrencyPair> currencyMap = listOfData.stream()
                .collect(Collectors.toMap(FormatPrivat::getCcy,
                        format -> new CurrencyPair(format.getBuy(), format.getSale())));
        bank.setUsd(currencyMap.get("USD"));
        bank.setEur(currencyMap.get("EUR"));
        bank.setPln(currencyMap.get("PLN"));
        bank.setBtc(currencyMap.get("BTC"));
        return bank;
    }

}
