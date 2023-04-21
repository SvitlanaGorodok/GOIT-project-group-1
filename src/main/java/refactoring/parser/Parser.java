package refactoring.parser;

import refactoring.bank.Bank;
import refactoring.format.Format;

import java.util.List;

public interface Parser<T extends Format> {
    public Bank parse(List<T> listOfData);
}
