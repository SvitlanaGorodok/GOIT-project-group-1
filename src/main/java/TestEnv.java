import refactoring.service.Initialization;
import refactoring.service.storage.CurrencyStorage;


public class TestEnv {
    public static void main(String[] args) {
        Initialization init = new Initialization();
        CurrencyStorage storage = new CurrencyStorage(init);
        storage.getMono();
        storage.getPrivat();
        storage.getNbu();
    }
}
