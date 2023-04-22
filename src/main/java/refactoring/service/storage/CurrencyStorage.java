package refactoring.service.storage;

import refactoring.service.Initialization;
import refactoring.model.jsonformat.FormatMono;
import refactoring.model.jsonformat.FormatNBU;
import refactoring.model.jsonformat.FormatPrivat;
import refactoring.service.datareader.HTTPRequestReader;
import refactoring.service.parser.ParserMono;
import refactoring.service.parser.ParserNBU;
import refactoring.service.parser.ParserPrivat;

import java.util.List;

public class CurrencyStorage {
    private Initialization init;

    public CurrencyStorage(Initialization init) {
        this.init = init;
    }

    public void getMono(){
        HTTPRequestReader<FormatMono> reader = new HTTPRequestReader<>();
        ParserMono parser = new ParserMono();
        List<FormatMono> list = reader.read(init.getClient(), init.getGson(), init.getMONOBANK_URL(), init.getTokenTypeMono());
        System.out.println("Mono: " + parser.parse(list));
    }

    public void getPrivat(){
        HTTPRequestReader<FormatPrivat> reader = new HTTPRequestReader<>();
        ParserPrivat parser = new ParserPrivat();
        List<FormatPrivat> list = reader.read(init.getClient(), init.getGson(), init.getPRIVAT_URL(), init.getTokenTypePrivat());
        List<FormatPrivat> pln = reader.read(init.getClient(), init.getGson(), init.getPRIVAT_PLN_URL(), init.getTokenTypePrivat());
        list.addAll(pln);
        System.out.println("Privat: " + parser.parse(list));
    }

    public void getNbu(){
        HTTPRequestReader<FormatNBU> reader = new HTTPRequestReader<>();
        ParserNBU parser = new ParserNBU();
        List<FormatNBU> list = reader.read(init.getClient(), init.getGson(), init.getNBU_URL(), init.getTokenTypeNbu());
        System.out.println("NBU: " + parser.parse(list));
    }
}
