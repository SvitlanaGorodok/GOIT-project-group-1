package keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import settings.Currency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCurrency {
    public static InlineKeyboardMarkup keyboard() {
        List<List<InlineKeyboardButton>> keyboardMenuCurrency = new ArrayList<>();
        for (Currency cur: Currency.values()){
            keyboardMenuCurrency.add(
                    Arrays.asList(
                            InlineKeyboardButton.builder()
                                    .text(cur.getCurrencyName() + Currency.getCurencyButtonsStatus(cur))
                                    .callbackData(cur.getCurrencyName() )
                                    .build()));
        }

        List<InlineKeyboardButton> keyboardMenuCurrency5 = new ArrayList<>();
        InlineKeyboardButton buttonBack = InlineKeyboardButton.builder()
                .text("↩️")
                .callbackData("SETTINGS")
                .build();
        keyboardMenuCurrency5.add(buttonBack);
        keyboardMenuCurrency.add(keyboardMenuCurrency5);

        return InlineKeyboardMarkup.builder().keyboard(keyboardMenuCurrency).build();
    }

}
