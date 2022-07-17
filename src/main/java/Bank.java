import java.util.Objects;

public class Bank {

    private String bankName;
    private Float USD_buy;
    private Float USD_sell;
    private Float EUR_buy;
    private Float EUR_sell;
    private Float PLN_buy;
    private Float PLN_sell;
    private Float Time;
    public Bank(String bankName, Float USD_buy, Float USD_sell, Float EUR_buy,
                Float EUR_sell, Float PLN_buy, Float PLN_sell, Float time) {
        this.bankName = bankName;
        this.USD_buy = USD_buy;
        this.USD_sell = USD_sell;
        this.EUR_buy = EUR_buy;
        this.EUR_sell = EUR_sell;
        this.PLN_buy = PLN_buy;
        this.PLN_sell = PLN_sell;
        Time = time;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public Float getUSD_buy() {
        return USD_buy;
    }
    public void setUSD_buy(Float USD_buy) {
        this.USD_buy = USD_buy;
    }
    public Float getUSD_sell() {
        return USD_sell;
    }
    public void setUSD_sell(Float USD_sell) {
        this.USD_sell = USD_sell;
    }
    public Float getEUR_buy() {
        return EUR_buy;
    }
    public void setEUR_buy(Float EUR_buy) {
        this.EUR_buy = EUR_buy;
    }
    public Float getEUR_sell() {
        return EUR_sell;
    }
    public void setEUR_sell(Float EUR_sell) {
        this.EUR_sell = EUR_sell;
    }
    public Float getPLN_buy() {
        return PLN_buy;
    }
    public void setPLN_buy(Float PLN_buy) {
        this.PLN_buy = PLN_buy;
    }
    public Float getPLN_sell() {
        return PLN_sell;
    }
    public void setPLN_sell(Float PLN_sell) {
        this.PLN_sell = PLN_sell;
    }
    public Float getTime() {
        return Time;
    }
    public void setTime(Float time) {
        Time = time;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(bankName, bank.bankName) && Objects.equals(USD_buy, bank.USD_buy) && Objects.equals(USD_sell, bank.USD_sell) && Objects.equals(EUR_buy, bank.EUR_buy) && Objects.equals(EUR_sell, bank.EUR_sell) && Objects.equals(PLN_buy, bank.PLN_buy) && Objects.equals(PLN_sell, bank.PLN_sell) && Objects.equals(Time, bank.Time);
    }
    @Override
    public int hashCode() {
        return Objects.hash(bankName, USD_buy, USD_sell, EUR_buy, EUR_sell, PLN_buy, PLN_sell, Time);
    }
    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", USD_buy=" + USD_buy +
                ", USD_sell=" + USD_sell +
                ", EUR_buy=" + EUR_buy +
                ", EUR_sell=" + EUR_sell +
                ", PLN_buy=" + PLN_buy +
                ", PLN_sell=" + PLN_sell +
                ", Time=" + Time +
                '}';
    }
}
