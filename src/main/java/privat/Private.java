package privat;

import java.util.Objects;

public class Private {
    private String ccy;
    private String base_ccy;
    private float buy;
    private float sale;

    public String getCcy() {
        return ccy;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public float getBuy() {
        return buy;
    }

    public float getSale() {
        return sale;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Private)) return false;
        Private aPrivate = (Private) o;
        return Objects.equals(ccy, aPrivate.ccy) && Objects.equals(base_ccy, aPrivate.base_ccy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccy, base_ccy);
    }

    @Override
    public String toString() {
        return "Private{" +
                "ccy='" + ccy + '\'' +
                ", base_ccy='" + base_ccy + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
