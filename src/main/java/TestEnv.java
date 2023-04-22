
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import refactoring.model.format.FormatMono;
import refactoring.model.format.FormatNBU;
import refactoring.service.datareader.DataReader;
import refactoring.model.format.FormatPrivat;
import refactoring.service.parser.ParserMono;
import refactoring.service.parser.ParserNBU;
import refactoring.service.parser.ParserPrivat;

import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.util.List;

public class TestEnv {
    private final static String PRIVAT_URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=11";
    private final static String MONOBANK_URL = "https://api.monobank.ua/bank/currency";
    private final static String NBU_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchangenew?json";
    static Type typeMono = new TypeToken<List<FormatMono>>() {
    }.getType();
    static Type typePrivat = new TypeToken<List<FormatPrivat>>() {
    }.getType();
    static Type typeNbu = new TypeToken<List<FormatNBU>>() {
    }.getType();

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        DataReader<FormatPrivat> dataReaderPrivat = new DataReader<>();
        List<FormatPrivat> privatList = dataReaderPrivat.read(client, gson, PRIVAT_URL, typePrivat);
        System.out.println("Private:\n" + privatList);
        ParserPrivat parserPrivat = new ParserPrivat();
        System.out.println(parserPrivat.parse(privatList));


        DataReader<FormatMono> dataReaderMono = new DataReader<>();
        List<FormatMono> monoList = dataReaderMono.read(client, gson, MONOBANK_URL, typeMono);
        System.out.println("Mono:\n" + monoList);
        ParserMono parserMono = new ParserMono();
        System.out.println(parserMono.parse(monoList));

        DataReader<FormatNBU> dataReaderNbu = new DataReader<>();
        List<FormatNBU> nbuList = dataReaderNbu.read(client, gson, NBU_URL, typeNbu);
        System.out.println("NBU: \n" + nbuList);
        ParserNBU parserNBU = new ParserNBU();
        System.out.println(parserNBU.parse(nbuList));
    }
}
