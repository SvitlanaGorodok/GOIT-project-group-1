package keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import settings.*;

import java.util.ArrayList;
import java.util.List;

public class MenuNotification {
    public static InlineKeyboardMarkup keyboard() {
        List<List<InlineKeyboardButton>> keyboardMenuNotification = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow4 = new ArrayList<>();
        InlineKeyboardButton buttonNotificationTime9 = InlineKeyboardButton.builder()
                .text(NotificationTime.NINE.getTime()+NotificationTime.getButtonStatus(NotificationTime.NINE))
                .callbackData(String.valueOf(NotificationTime.NINE.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime10 = InlineKeyboardButton.builder()
                .text(NotificationTime.TEN.getTime()+NotificationTime.getButtonStatus(NotificationTime.TEN))
                .callbackData(String.valueOf(NotificationTime.TEN.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime11 = InlineKeyboardButton.builder()
                .text(NotificationTime.ELEVEN.getTime()+NotificationTime.getButtonStatus(NotificationTime.ELEVEN))
                .callbackData(String.valueOf(NotificationTime.ELEVEN.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime12 = InlineKeyboardButton.builder()
                .text(NotificationTime.TWELVE.getTime()+NotificationTime.getButtonStatus(NotificationTime.TWELVE))
                .callbackData(String.valueOf(NotificationTime.TWELVE.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime13 = InlineKeyboardButton.builder()
                .text(NotificationTime.THIRTEEN.getTime()+NotificationTime.getButtonStatus(NotificationTime.THIRTEEN))
                .callbackData(String.valueOf(NotificationTime.THIRTEEN.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime14 = InlineKeyboardButton.builder()
                .text(NotificationTime.FOURTEEN.getTime()+NotificationTime.getButtonStatus(NotificationTime.FOURTEEN))
                .callbackData(String.valueOf(NotificationTime.FOURTEEN.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime15 = InlineKeyboardButton.builder()
                .text(NotificationTime.FIFTEEN.getTime()+NotificationTime.getButtonStatus(NotificationTime.FIFTEEN))
                .callbackData(String.valueOf(NotificationTime.FIFTEEN.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime16 = InlineKeyboardButton.builder()
                .text(NotificationTime.SIXTEEN.getTime()+NotificationTime.getButtonStatus(NotificationTime.SIXTEEN))
                .callbackData(String.valueOf(NotificationTime.SIXTEEN.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime17 = InlineKeyboardButton.builder()
                .text(NotificationTime.SEVENTEEN.getTime()+NotificationTime.getButtonStatus(NotificationTime.SEVENTEEN))
                .callbackData(String.valueOf(NotificationTime.SEVENTEEN.getTime()))
                .build();
        InlineKeyboardButton buttonNotificationTime18 = InlineKeyboardButton.builder()
                .text(NotificationTime.EIGHTEEN.getTime()+NotificationTime.getButtonStatus(NotificationTime.EIGHTEEN))
                .callbackData(String.valueOf(NotificationTime.EIGHTEEN.getTime()))
                .build();
        InlineKeyboardButton buttonTurnOfNotification = InlineKeyboardButton.builder()
                .text("Вимкнути сповіщення"+NotificationTime.getButtonStatus(NotificationTime.SWICH_OFF))
                .callbackData(String.valueOf(NotificationTime.SWICH_OFF.getTime()))
                .build();
        InlineKeyboardButton buttonBack = InlineKeyboardButton.builder()
                .text(Buttons.BACK_TO_SETTINGS.getName())
                .callbackData(Buttons.BACK_TO_SETTINGS.getNameEN())
                .build();
        keyboardMSetRow1.add(buttonNotificationTime9);
        keyboardMSetRow1.add(buttonNotificationTime10);
        keyboardMSetRow1.add(buttonNotificationTime11);
        keyboardMSetRow2.add(buttonNotificationTime12);
        keyboardMSetRow2.add(buttonNotificationTime13);
        keyboardMSetRow2.add(buttonNotificationTime14);
        keyboardMSetRow3.add(buttonNotificationTime15);
        keyboardMSetRow3.add(buttonNotificationTime16);
        keyboardMSetRow3.add(buttonNotificationTime17);
        keyboardMSetRow4.add(buttonNotificationTime18);
        keyboardMSetRow4.add(buttonTurnOfNotification);
        keyboardMSetRow4.add(buttonBack);
        keyboardMenuNotification.add(keyboardMSetRow1);
        keyboardMenuNotification.add(keyboardMSetRow2);
        keyboardMenuNotification.add(keyboardMSetRow3);
        keyboardMenuNotification.add(keyboardMSetRow4);

        return InlineKeyboardMarkup.builder().keyboard(keyboardMenuNotification).build();
    }
}
