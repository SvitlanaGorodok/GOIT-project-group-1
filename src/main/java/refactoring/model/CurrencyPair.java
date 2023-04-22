package refactoring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class CurrencyPair {
    float buy;
    float sell;

    @Override
    public String toString() {
        return "{" +
                "buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
