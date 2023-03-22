package newway.format;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// View of currency values in json format for Privat bank
public class FormatPrivat extends Format {
    private String ccy;
    private String base_ccy;
    private float buy;
    private float sale;
}
