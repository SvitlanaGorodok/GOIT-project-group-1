package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.Banks;
import refactoring.model.buttonnames.BasicButtons;

import java.util.List;

public class MenuBank implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(Banks.PRIVAT.name(), Banks.MONO.name(), Banks.NBU.name(),
                BasicButtons.BACK_TO_SETTINGS.name(), BasicButtons.BACK_TO_START.name());
        createMenu(buttons, 3, message);
        return message;
    }
}
