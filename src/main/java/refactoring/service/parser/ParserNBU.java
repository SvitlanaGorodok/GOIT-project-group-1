package refactoring.service.parser;

import refactoring.model.Bank;
import refactoring.model.CurrencyPair;
import refactoring.model.jsonformat.FormatNBU;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserNBU implements Parser<FormatNBU> {
    @Override
    public Bank parse(List<FormatNBU> listOfData) {
        Bank bank = new Bank();
        Map<String, CurrencyPair> currencyMap = listOfData.stream()
                .collect(Collectors.toMap(FormatNBU::getCc,
                        format -> new CurrencyPair(format.getRate(), format.getRate())));
        bank.setUsd(currencyMap.getOrDefault("USD", new CurrencyPair(0.0f, 0.0f)));
        bank.setEur(currencyMap.getOrDefault("EUR", new CurrencyPair(0.0f, 0.0f)));
        bank.setPln(currencyMap.getOrDefault("PLN", new CurrencyPair(0.0f, 0.0f)));
        return bank;
    }
}
