package keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.List;

public class MenuCurrency {
    public static InlineKeyboardMarkup keyboard() {
        List<List<InlineKeyboardButton>> keyboardMenuCurrency = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency4 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency5 = new ArrayList<>();
        InlineKeyboardButton buttonUsd = InlineKeyboardButton.builder()
                .text("USD")
                .callbackData("USD")
                .build();
        InlineKeyboardButton buttonEur = InlineKeyboardButton.builder()
                .text("EUR")
                .callbackData("EUR")
                .build();
        InlineKeyboardButton buttonPln = InlineKeyboardButton.builder()
                .text("PLN")
                .callbackData("PLN")
                .build();
        InlineKeyboardButton buttonBtc = InlineKeyboardButton.builder()
                .text("BITCOIN")
                .callbackData("BTC")
                .build();
        InlineKeyboardButton buttonBack = InlineKeyboardButton.builder()
                .text("↩️")
                .callbackData("SETTINGS")
                .build();
        keyboardMenuCurrency1.add(buttonUsd);
        keyboardMenuCurrency2.add(buttonEur);
        keyboardMenuCurrency3.add(buttonPln);
        keyboardMenuCurrency4.add(buttonBtc);
        keyboardMenuCurrency5.add(buttonBack);
        keyboardMenuCurrency.add(keyboardMenuCurrency1);
        keyboardMenuCurrency.add(keyboardMenuCurrency2);
        keyboardMenuCurrency.add(keyboardMenuCurrency3);
        keyboardMenuCurrency.add(keyboardMenuCurrency4);
        keyboardMenuCurrency.add(keyboardMenuCurrency5);

        return InlineKeyboardMarkup.builder().keyboard(keyboardMenuCurrency).build();
    }
}
