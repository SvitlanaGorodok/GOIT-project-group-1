package privat;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class APIPrivat {
    private static final String PRIVAT_URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    public static void main(String[] args) throws IOException, InterruptedException {
        final List<Private> date = HttpUtil.sendGetBank(URI.create(PRIVAT_URL));
        System.out.println("Our Private "+date);
    }
}
