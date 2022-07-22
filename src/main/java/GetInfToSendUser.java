import settings.Settings;
import java.util.Map;

public class GetInfToSendUser {
    public void getUserSett(int checkTime){
        for (Map.Entry userSet : Settings.settings.entrySet()){
            Long key = (Long) userSet.getKey();
            if (Settings.settings.get(key).getNotificationTime().getTime() == checkTime){
            }
        }
    }
}