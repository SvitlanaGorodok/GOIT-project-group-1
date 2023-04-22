package refactoring.service.parser;

import refactoring.model.Bank;
import refactoring.model.CurrencyPair;
import refactoring.model.jsonformat.FormatPrivat;

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
        bank.setUsd(currencyMap.getOrDefault("USD", new CurrencyPair(0.0f, 0.0f)));
        bank.setEur(currencyMap.getOrDefault("EUR", new CurrencyPair(0.0f, 0.0f)));
        bank.setPln(currencyMap.getOrDefault("PLZ", new CurrencyPair(0.0f, 0.0f)));
        return bank;
    }

}
