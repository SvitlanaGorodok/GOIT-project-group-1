package refactoring.service.parser;

import refactoring.model.Bank;
import refactoring.model.format.Format;

import java.util.List;

public interface Parser<T extends Format> {
    public Bank parse(List<T> listOfData);
}
