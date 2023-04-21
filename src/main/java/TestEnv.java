import com.google.gson.Gson;
import refactoring.datareader.DataReader;
import refactoring.format.FormatMono;
import refactoring.format.FormatNBU;
import refactoring.format.FormatPrivat;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

public class TestEnv {
    private final static String PRIVAT_URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=11";
    private final static String MONOBANK_URL = "https://api.monobank.ua/bank/currency";
    private final static String NBU_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchangenew?json";

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        DataReader<FormatPrivat> dataReaderPrivat = new DataReader<>();
        List<FormatPrivat> privatList = dataReaderPrivat.read(client, gson, PRIVAT_URL);
        System.out.println("Private:\n" + privatList);

//        DataReader<FormatMono> dataReaderMono = new DataReader<>();
//        List<FormatMono> monoList = dataReaderMono.read(client, gson, MONOBANK_URL);
//        System.out.println("Mono:\n" + monoList);
//
//        DataReader<FormatNBU> dataReaderNbu = new DataReader<>();
//        List<FormatNBU> nbuList = dataReaderNbu.read(client, gson, NBU_URL);
//        System.out.println("NBU: \n" + nbuList);
    }
}
