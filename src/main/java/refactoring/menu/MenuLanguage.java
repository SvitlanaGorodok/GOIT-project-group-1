package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButtons;
import refactoring.model.buttonnames.Languages;

import java.util.List;

public class MenuLanguage implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(Languages.EN.name(), Languages.UA.name(), Languages.PL.name(),
                Languages.CZ.name(), Languages.RU.name(), BasicButtons.BACK_TO_SETTINGS.name(), BasicButtons.BACK_TO_START.name());
        createMenu(buttons, 3, message);
        return message;
    }
}
