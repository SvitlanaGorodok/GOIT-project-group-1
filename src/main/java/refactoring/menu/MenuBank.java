package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BankName;
import refactoring.model.buttonnames.BasicButton;

import java.util.List;

public class MenuBank implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(BankName.PRIVAT.name(), BankName.MONO.name(), BankName.NBU.name(),
                BasicButton.BACK_TO_SETTINGS.name(), BasicButton.BACK_TO_START.name());
        createMenu(buttons, 3, message);
        return message;
    }
}
