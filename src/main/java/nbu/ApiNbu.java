package nbu;

import serviceClasses.Bank;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class ApiNbu {
    private static final String NBU_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchangenew?json";

    public static void main(String[] args) throws IOException, InterruptedException {
        final List<NbuBank> dateNBU = HttpUtil.sendGetBank(URI.create(NBU_URL));
        System.out.println("NBU:\n"+dateNBU);

        Bank bank = HttpUtil.getNbu(dateNBU);

        System.out.println("bank = " + bank);
    }
}
