package Monobank;

import java.util.Objects;

public class Monobank {

    private int currencyCodeA;
    private int currencyCodeB;
    private int date;
    private float rateBuy;
    private float rateSell;
    private float rateCross;

    public Monobank(int currencyCodeA, int currencyCodeB, int date, float rateBuy, float rateSell, float rateCross) {
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
        this.rateCross = rateCross;
    }

    public int getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(int currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public int getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(int currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public float getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(float rateBuy) {
        this.rateBuy = rateBuy;
    }

    public float getRateSell() {
        return rateSell;
    }

    public void setRateSell(float rateSell) {
        this.rateSell = rateSell;
    }

    public float getRateCross() {
        return rateCross;
    }

    public void setRateCross(float rateCross) {
        this.rateCross = rateCross;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monobank monobank = (Monobank) o;
        return currencyCodeA == monobank.currencyCodeA
                && currencyCodeB == monobank.currencyCodeB
                && date == monobank.date
                && Float.compare(monobank.rateBuy, rateBuy) == 0
                && Float.compare(monobank.rateSell, rateSell) == 0
                && Float.compare(monobank.rateCross, rateCross) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCodeA, currencyCodeB, date, rateBuy, rateSell, rateCross);
    }

    @Override
    public String toString() {
        return "Monobank{" +
                "currencyCodeA=" + currencyCodeA +
                ", currencyCodeB=" + currencyCodeB +
                ", date=" + date +
                ", rateBuy=" + rateBuy +
                ", rateSell=" + rateSell +
                ", rateCross=" + rateCross +
                '}';
    }
}
