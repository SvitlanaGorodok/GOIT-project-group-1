package keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

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
                .text("9")
                .callbackData("NotificationTime9")
                .build();
        InlineKeyboardButton buttonNotificationTime10 = InlineKeyboardButton.builder()
                .text("10")
                .callbackData("NotificationTime10")
                .build();
        InlineKeyboardButton buttonNotificationTime11 = InlineKeyboardButton.builder()
                .text("11")
                .callbackData("NotificationTime11")
                .build();
        InlineKeyboardButton buttonNotificationTime12 = InlineKeyboardButton.builder()
                .text("12")
                .callbackData("NotificationTime12")
                .build();
        InlineKeyboardButton buttonNotificationTime13 = InlineKeyboardButton.builder()
                .text("13")
                .callbackData("NotificationTime13")
                .build();
        InlineKeyboardButton buttonNotificationTime14 = InlineKeyboardButton.builder()
                .text("14")
                .callbackData("NotificationTime14")
                .build();
        InlineKeyboardButton buttonNotificationTime15 = InlineKeyboardButton.builder()
                .text("15")
                .callbackData("NotificationTime15")
                .build();
        InlineKeyboardButton buttonNotificationTime16 = InlineKeyboardButton.builder()
                .text("16")
                .callbackData("NotificationTime16")
                .build();
        InlineKeyboardButton buttonNotificationTime17 = InlineKeyboardButton.builder()
                .text("17")
                .callbackData("NotificationTime17")
                .build();
        InlineKeyboardButton buttonNotificationTime18 = InlineKeyboardButton.builder()
                .text("18")
                .callbackData("NotificationTime18")
                .build();
        InlineKeyboardButton buttonTurnOfNotification = InlineKeyboardButton.builder()
                .text("Вимкнути сповіщення")
                .callbackData("TurnOfNotification")
                .build();
        InlineKeyboardButton buttonBack = InlineKeyboardButton.builder()
                .text("↩️")
                .callbackData("BackToSettings")
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
