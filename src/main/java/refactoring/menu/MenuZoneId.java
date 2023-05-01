package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButtons;
import refactoring.model.buttonnames.ZoneId;

import java.util.List;

public class MenuZoneId implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        List<String> buttons = List.of(
                ZoneId.UTC_ZERO.name(), ZoneId.UTC_ONE.name(), ZoneId.UTC_TWO.name(), ZoneId.UTC_THREE.name(),
                ZoneId.UTC_FOUR.name(), ZoneId.UTC_FIVE.name(), ZoneId.UTC_SIX.name(), ZoneId.UTC_SEVEN.name(),
                ZoneId.UTC_EIGHT.name(), ZoneId.UTC_NINE.name(), ZoneId.UTC_TEN.name(), ZoneId.UTC_ELEVEN.name(),
                ZoneId.UTC_TWELVE.name(), ZoneId.UTC_MINUS_ONE.name(), ZoneId.UTC_MINUS_TWO.name(), ZoneId.UTC_MINUS_THREE.name(),
                ZoneId.UTC_MINUS_FOUR.name(), ZoneId.UTC_MINUS_FIVE.name(), ZoneId.UTC_MINUS_SIX.name(),
                ZoneId.UTC_MINUS_SEVEN.name(), ZoneId.UTC_MINUS_EIGHT.name(), ZoneId.UTC_MINUS_NINE.name(),
                ZoneId.UTC_MINUS_TEN.name(), ZoneId.UTC_MINUS_ELEVEN.name(), ZoneId.UTC_MINUS_TWELVE.name(),
                BasicButtons.BACK_TO_SETTINGS.name(), BasicButtons.BACK_TO_START.name());
        createMenu(buttons, 4, message);
        return message;
    }
}
