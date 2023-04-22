package refactoring.model.format;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
// View of currency values in json format for NBU bank
public class FormatNBU extends Format {
    private int r030;
    private String txt;
    private float rate;
    private String cc;
    private String exchangedate ;
}
