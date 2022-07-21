package settings;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    public static Map<Long, Setting> settings = new HashMap<>();
    public static String getInfo (Long chatId) {
        return settings.get(chatId).toString();
    }
}
