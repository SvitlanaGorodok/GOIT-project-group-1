package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButton;
import refactoring.model.buttonnames.DecimalPlaces;

import java.util.List;

public class MenuDecimalPlace implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(DecimalPlaces.TWO.name(), DecimalPlaces.THREE.name(), DecimalPlaces.FOUR.name(),
                BasicButton.BACK_TO_SETTINGS.name(), BasicButton.BACK_TO_START.name());
        createMenu(buttons, 3, message);
        return message;
    }
}
