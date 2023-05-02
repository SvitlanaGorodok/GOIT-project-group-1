package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButton;

import java.util.List;

public class MenuStart implements Menu {
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(BasicButton.GET_INFO.name(), BasicButton.SETTINGS.name());
        createMenu(buttons, 1, message);
        return message;
    }
}
