package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import refactoring.model.buttonnames.BasicButton;
import refactoring.model.buttonnames.Language;
import refactoring.service.translator.Translator;
import refactoring.service.translator.ZoneIdTranslator;

import java.util.List;

public class MenuZoneId implements Menu{
    @Override
    public SendMessage printMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId.toString(), "Please choose option:");
        Translator translator = new ZoneIdTranslator();
        List<String> buttons = translator.translate(Language.UA);
        buttons.addAll(List.of(BasicButton.BACK_TO_SETTINGS.name(), BasicButton.BACK_TO_START.name()));
        createMenu(buttons, 4, message);
        return message;
    }
}
