package refactoring.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import refactoring.model.jsonformat.FormatMono;
import refactoring.model.jsonformat.FormatNBU;
import refactoring.model.jsonformat.FormatPrivat;

import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.util.List;

@Getter
public class Initialization {
    private final String PRIVAT_URL;
    private final String PRIVAT_PLN_URL;
    private final String MONOBANK_URL;
    private final String NBU_URL;
    private final Type tokenTypeMono;
    private final Type tokenTypePrivat;
    private final Type tokenTypeNbu;
    private final HttpClient client;
    private final Gson gson;

    public Initialization() {
        this.PRIVAT_URL  = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=11";
        this.PRIVAT_PLN_URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=12";
        this.MONOBANK_URL = "https://api.monobank.ua/bank/currency";
        this.NBU_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchangenew?json";
        this.tokenTypeMono = new TypeToken<List<FormatMono>>() {}.getType();
        this.tokenTypePrivat = new TypeToken<List<FormatPrivat>>() {}.getType();
        this.tokenTypeNbu = new TypeToken<List<FormatNBU>>() {}.getType();
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }
}
