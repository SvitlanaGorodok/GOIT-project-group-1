package settings;

import settings.Banks;
import settings.Currency;
import settings.Settings;

import java.util.List;
import java.util.Map;

public class GetInfToSendUser {
    public void getUserSett(int checkTime){
        for (Map.Entry userSet : Settings.settings.entrySet()){
            Long key = (Long) userSet.getKey();
            Long chatId = Settings.settings.get(key).getChatId();
            int userNotificationTime = Settings.settings.get(key).getNotificationTime().getTime();
            Banks userSelectedBank = Settings.settings.get(key).getSelectedBank();
            List<Currency> userCurrency = Settings.settings.get(key).getSelectedCurrency();
            if (userNotificationTime == checkTime){
                switch (userSelectedBank){
                    case PRIVATE:
                        break;
                    case MONO:
                        break;
                    case NBU:
                        break;
                }
                for (Currency currency : userCurrency) {
                }
            }
        }
    }
}