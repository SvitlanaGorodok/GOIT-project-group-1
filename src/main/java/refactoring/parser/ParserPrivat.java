package refactoring.parser;

import refactoring.bank.Bank;
import refactoring.format.FormatPrivat;

import java.util.List;

public class ParserPrivat implements Parser<FormatPrivat> {
    @Override
    public Bank parse(List<FormatPrivat> listOfData) {
        Bank bank = new Bank();
        for (FormatPrivat privat : listOfData) {
            switch (privat.getCcy()) {
                case "USD":
                    bank.setUSD_buy(privat.getBuy());
                    bank.setUSD_sell(privat.getSale());
                    break;
                case "EUR":
                    bank.setEUR_buy(privat.getBuy());
                    bank.setEUR_sell(privat.getSale());
                    break;
                case "PLZ":
                    bank.setPLN_buy(privat.getBuy());
                    bank.setPLN_sell(privat.getSale());
                    break;
                case "BTC":
                    bank.setBTC_buy(privat.getBuy());
                    bank.setBTC_sell(privat.getSale());
                    break;
            }
        }
        return bank;
    }

}
