package refactoring.model.format;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
// View of currency values in json format for Privat bank
public class FormatPrivat extends Format {
    private String ccy;
    private String base_ccy;
    private float buy;
    private float sale;
}
