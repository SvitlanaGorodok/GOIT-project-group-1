package settings;

import serviceClasses.Bank;
import serviceClasses.CurrencyDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Settings {
    public static Map<Long, Setting> settings = new HashMap<>();



    public static String getInfo (Long chatId) {
        StringBuilder messageToUser = new StringBuilder();
        Setting userSetting = settings.get(chatId);
        String bankName = userSetting.getSelectedBank().getBankNameUA();
        messageToUser.append(bankName).append("\n");
        int numberDecPlaces = userSetting.getNumberOfDecimalPlaces();
        List<Currency> currencies = userSetting.getSelectedCurrency();
        Bank bankInfo = CurrencyDataBase.getCurrentInfo(userSetting.getSelectedBank());
        for (Currency currency: currencies){
            messageToUser.append("Курс купівлі ")
                    .append(currency.getCurrencyName())
                    .append(" - ")
                    .append(Math.round(bankInfo.getBuyRate(currency) * Math.pow(10,numberDecPlaces))
                            /Math.pow(10,numberDecPlaces))
                    .append("\n");
            messageToUser.append("Курс продажу ")
                    .append(currency.getCurrencyName())
                    .append(" - ")
                    .append(Math.round(bankInfo.getSellRate(currency) * Math.pow(10,numberDecPlaces))
                            /Math.pow(10,numberDecPlaces))
                    .append("\n");
        }
        return messageToUser.toString();
    }
}
