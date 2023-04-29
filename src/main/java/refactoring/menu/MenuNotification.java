package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

public class MenuNotification implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of("NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN",
                "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN",
                "SWICH_OFF", "BACK_TO_START", "BACK_TO_SETTINGS");
        createMenu(buttons, 5, message);
        return message;
    }
}
