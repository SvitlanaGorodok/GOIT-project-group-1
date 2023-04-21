package refactoring.bank;

public class CurrencyPair {
    float buy;
    float sell;

    public CurrencyPair(float buy, float sell) {
        this.buy = buy;
        this.sell = sell;
    }

    public float getBuy() {
        return buy;
    }

    public float getSell() {
        return sell;
    }
}
