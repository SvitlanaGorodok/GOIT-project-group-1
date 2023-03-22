package newway.format;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// View of currency values in json format for NBU bank
public class FormatNBU extends Format {
    private int r030;
    private String txt;
    private float rate;
    private String cc;
    private String exchangedate ;
}
