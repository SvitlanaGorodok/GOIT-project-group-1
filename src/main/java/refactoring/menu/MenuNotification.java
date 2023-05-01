package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButtons;
import refactoring.model.buttonnames.Notifications;

import java.util.List;

public class MenuNotification implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(Notifications.NINE.name(), Notifications.TEN.name(), Notifications.ELEVEN.name(),
                Notifications.TWELVE.name(), Notifications.THIRTEEN.name(), Notifications.FOURTEEN.name(),
                Notifications.FIFTEEN.name(), Notifications.SIXTEEN.name(), Notifications.SEVENTEEN.name(),
                Notifications.EIGHTEEN.name(), Notifications.SWITCH_OFF.name(),
                BasicButtons.BACK_TO_SETTINGS.name(), BasicButtons.BACK_TO_START.name());
        createMenu(buttons, 5, message);
        return message;
    }
}
