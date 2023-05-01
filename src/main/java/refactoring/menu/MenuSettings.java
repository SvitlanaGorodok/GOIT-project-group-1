package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButtons;
import refactoring.model.buttonnames.Settings;

import java.util.List;

public class MenuSettings implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(Settings.BANK.name(), Settings.CURRENCY.name(), Settings.NUM_DECIMAL_PLACES.name(),
                Settings.NOTIFICATION.name(), Settings.ZONEID.name(), Settings.LANGUAGE.name(),
                BasicButtons.BACK_TO_SETTINGS.name(), BasicButtons.BACK_TO_START.name());
        createMenu(buttons, 3, message);
        return message;
    }
}
