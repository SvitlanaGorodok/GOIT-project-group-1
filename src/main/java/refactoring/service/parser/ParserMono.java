package refactoring.service.parser;

import refactoring.model.Bank;
import refactoring.model.CurrencyPair;
import refactoring.model.format.FormatMono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserMono implements Parser<FormatMono> {
    @Override
    public Bank parse(List<FormatMono> listOfData) {
        Bank bank = new Bank();
        Map<Integer, CurrencyPair> currencyMap = listOfData.stream()
                .filter(format -> format.getCurrencyCodeB() == 980)
                .collect(Collectors.toMap(FormatMono::getCurrencyCodeA,
                        format -> new CurrencyPair(format.getRateBuy(), format.getRateSell())));
        bank.setUsd(currencyMap.get(840));
        bank.setEur(currencyMap.get(978));
        bank.setPln(currencyMap.get(985));
        return bank;
    }
}
