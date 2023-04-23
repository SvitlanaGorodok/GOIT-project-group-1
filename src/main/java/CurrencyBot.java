import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class CurrencyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "@CurrencyInfoProjectGroup1TestBot";
    }

    @Override
    public String getBotToken() {
        return "5553351040:AAHugdZyMWm_u8av-bQqsEaP6Et7WXPsOtk";
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton("BTN 1");
        keyboardRow.add(keyboardButton);
        replyKeyboardMarkup.setKeyboard(List.of(keyboardRow));
        SendMessage message = new SendMessage();
        message.setText("Hello");
        message.setChatId(chatId);
        message.setReplyMarkup(replyKeyboardMarkup);
        sendApiMethod(message);
    }

    private Long getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getFrom().getId();
        }

        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }
}
