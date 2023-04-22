package refactoring.service.parser;

import refactoring.model.Bank;
import refactoring.model.CurrencyPair;
import refactoring.model.format.FormatNBU;

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
        bank.setUsd(currencyMap.get("USD"));
        bank.setEur(currencyMap.get("EUR"));
        bank.setPln(currencyMap.get("PLN"));
        bank.setBtc(currencyMap.get("BTC"));
        return bank;
    }
}
