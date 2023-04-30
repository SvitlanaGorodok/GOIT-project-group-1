package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

public class MenuZoneId implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of("UTC 0", "UTC +1", "UTC +2", "UTC +3",
                "UTC +4", "UTC +5", "UTC +6", "UTC +7",
                "UTC +8", "UTC +9", "UTC +10", "UTC +11",
                "UTC +12", "UTC -1", "UTC -2", "UTC -3",
                "UTC -4", "UTC -5", "UTC -6", "UTC -7",
                "UTC -8", "UTC -9", "UTC -10", "UTC -11",
                "UTC -12", "BACK_TO_START", "BACK_TO_SETTINGS");
        createMenu(buttons, 4, message);
        return message;
    }
}
