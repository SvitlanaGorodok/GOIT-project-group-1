package refactoring.service.parser;

import refactoring.model.Bank;
import refactoring.model.CurrencyPair;
import refactoring.model.jsonformat.FormatMono;

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
                        format -> format.getCurrencyCodeA() == 985 ?
                                new CurrencyPair(format.getRateCross(), format.getRateCross()) :
                                new CurrencyPair(format.getRateBuy(), format.getRateSell())));
        bank.setUsd(currencyMap.getOrDefault(840, new CurrencyPair(0.0f, 0.0f)));
        bank.setEur(currencyMap.getOrDefault(978, new CurrencyPair(0.0f, 0.0f)));
        bank.setPln(currencyMap.getOrDefault(985, new CurrencyPair(0.0f, 0.0f)));
        return bank;
    }
}
