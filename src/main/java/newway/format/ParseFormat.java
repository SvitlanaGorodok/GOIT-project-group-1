package newway.format;

import newway.bank.Bank;

import java.util.List;

public interface ParseFormat {
    public Bank parse(List<Format> listOfData);
}
