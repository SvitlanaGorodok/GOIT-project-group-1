package refactoring.service.translator;

import refactoring.model.buttonnames.Language;
import refactoring.model.buttonnames.ZoneId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ZoneIdTranslator implements Translator{
    @Override
    public List<String> translate(Language language) {
        List<ZoneId> buttons = List.of(
                ZoneId.UTC_ZERO, ZoneId.UTC_ONE, ZoneId.UTC_TWO, ZoneId.UTC_THREE,
                ZoneId.UTC_FOUR, ZoneId.UTC_FIVE, ZoneId.UTC_SIX, ZoneId.UTC_SEVEN,
                ZoneId.UTC_EIGHT, ZoneId.UTC_NINE, ZoneId.UTC_TEN, ZoneId.UTC_ELEVEN,
                ZoneId.UTC_TWELVE, ZoneId.UTC_MINUS_ONE, ZoneId.UTC_MINUS_TWO, ZoneId.UTC_MINUS_THREE,
                ZoneId.UTC_MINUS_FOUR, ZoneId.UTC_MINUS_FIVE, ZoneId.UTC_MINUS_SIX,
                ZoneId.UTC_MINUS_SEVEN, ZoneId.UTC_MINUS_EIGHT, ZoneId.UTC_MINUS_NINE,
                ZoneId.UTC_MINUS_TEN, ZoneId.UTC_MINUS_ELEVEN, ZoneId.UTC_MINUS_TWELVE);
        return buttons.stream()
                .map(this::getName)
                .collect(Collectors.toList());
    }

    private String getName(ZoneId zoneId){
        Map<ZoneId, String> zoneIdNameMap = new HashMap<>();
        zoneIdNameMap.put(ZoneId.UTC_ZERO, "UTC 0");
        zoneIdNameMap.put(ZoneId.UTC_ONE, "UTC +1");
        zoneIdNameMap.put(ZoneId.UTC_TWO, "UTC +2");
        zoneIdNameMap.put(ZoneId.UTC_THREE, "UTC +3");
        zoneIdNameMap.put(ZoneId.UTC_FOUR, "UTC +4");
        zoneIdNameMap.put(ZoneId.UTC_FIVE, "UTC +5");
        zoneIdNameMap.put(ZoneId.UTC_SIX, "UTC +6");
        zoneIdNameMap.put(ZoneId.UTC_SEVEN, "UTC +7");
        zoneIdNameMap.put(ZoneId.UTC_EIGHT, "UTC +8");
        zoneIdNameMap.put(ZoneId.UTC_NINE, "UTC +9");
        zoneIdNameMap.put(ZoneId.UTC_TEN, "UTC +10");
        zoneIdNameMap.put(ZoneId.UTC_ELEVEN, "UTC +11");
        zoneIdNameMap.put(ZoneId.UTC_TWELVE, "UTC +12");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_ONE, "UTC -1");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_TWO, "UTC -2");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_THREE, "UTC -3");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_FOUR, "UTC -4");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_FIVE, "UTC -5");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_SIX, "UTC -6");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_SEVEN, "UTC -7");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_EIGHT, "UTC -8");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_NINE, "UTC -9");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_TEN, "UTC -10");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_ELEVEN, "UTC -11");
        zoneIdNameMap.put(ZoneId.UTC_MINUS_TWELVE, "UTC -12");
        return zoneIdNameMap.get(zoneId);
    }
}