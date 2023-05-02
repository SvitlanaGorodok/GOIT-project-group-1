package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButton;
import refactoring.model.buttonnames.Language;

import java.util.List;

public class MenuLanguage implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(Language.EN.name(), Language.UA.name(), Language.PL.name(),
                Language.CZ.name(), Language.RU.name(), BasicButton.BACK_TO_SETTINGS.name(), BasicButton.BACK_TO_START.name());
        createMenu(buttons, 3, message);
        return message;
    }
}
