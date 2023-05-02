package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButton;
import refactoring.model.buttonnames.NotificationTime;

import java.util.List;

public class MenuNotification implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(NotificationTime.NINE.name(), NotificationTime.TEN.name(), NotificationTime.ELEVEN.name(),
                NotificationTime.TWELVE.name(), NotificationTime.THIRTEEN.name(), NotificationTime.FOURTEEN.name(),
                NotificationTime.FIFTEEN.name(), NotificationTime.SIXTEEN.name(), NotificationTime.SEVENTEEN.name(),
                NotificationTime.EIGHTEEN.name(), NotificationTime.SWITCH_OFF.name(),
                BasicButton.BACK_TO_SETTINGS.name(), BasicButton.BACK_TO_START.name());
        createMenu(buttons, 5, message);
        return message;
    }
}
