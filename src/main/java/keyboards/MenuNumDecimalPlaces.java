package keyboards;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import settings.Buttons;

import java.util.ArrayList;
import java.util.List;

public class MenuNumDecimalPlaces {
    public static InlineKeyboardMarkup keyboard() {
        List<List<InlineKeyboardButton>> keyboard =  new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow4 = new ArrayList<>();
        InlineKeyboardButton buttonNumberOfDecimalPlaces2 = InlineKeyboardButton.builder()
                .text(NumberOfDecimalPlaces.TWO.getIntNumber()+NumberOfDecimalPlaces.getButtonStatus(NumberOfDecimalPlaces.TWO))
                .callbackData(NumberOfDecimalPlaces.TWO.getNameDecPlaces())
                .build();
        InlineKeyboardButton buttonNumberOfDecimalPlaces3 = InlineKeyboardButton.builder()
                .text(NumberOfDecimalPlaces.THREE.getIntNumber()+NumberOfDecimalPlaces.getButtonStatus(NumberOfDecimalPlaces.THREE))
                .callbackData(NumberOfDecimalPlaces.THREE.getNameDecPlaces())
                .build();
        InlineKeyboardButton buttonNumberOfDecimalPlaces4 = InlineKeyboardButton.builder()
                .text(NumberOfDecimalPlaces.FOUR.getIntNumber()+NumberOfDecimalPlaces.getButtonStatus(NumberOfDecimalPlaces.FOUR))
                .callbackData(NumberOfDecimalPlaces.FOUR.getNameDecPlaces())
                .build();
        InlineKeyboardButton buttonBackToSetting = InlineKeyboardButton.builder()
                .text(Buttons.BACK_TO_SETTINGS.getName())
                .callbackData(Buttons.BACK_TO_SETTINGS.getNameEN())
                .build();
        keyboardMSetRow1.add(buttonNumberOfDecimalPlaces2);
        keyboardMSetRow2.add(buttonNumberOfDecimalPlaces3);
        keyboardMSetRow3.add(buttonNumberOfDecimalPlaces4);
        keyboardMSetRow4.add(buttonBackToSetting);
        keyboard.add(keyboardMSetRow1);
        keyboard.add(keyboardMSetRow2);
        keyboard.add(keyboardMSetRow3);
        keyboard.add(keyboardMSetRow4);

        return InlineKeyboardMarkup.builder().keyboard(keyboard).build();
    }
}

