import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CurrencyInfoBot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "@CurrencyInfoProjectGroup1Bot";
    }

    @Override
    public String getBotToken() {
        return "5416117406:AAE1XHQxbn8TIY2perQrAAiQsNcxlcth9Wo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            try {
                handleMessage(update.getMessage());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void handleMessage(Message message) throws TelegramApiException {
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> comandEntity = message.getEntities().stream()
                    .filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (comandEntity.isPresent()) {
                String commad = message.getText()
                        .substring(comandEntity.get().getOffset(), comandEntity.get().getLength());
                switch (commad) {
                    case "/start":
                        List<List<InlineKeyboardButton>> buttonsSetingsAndInfo = new ArrayList<>();
                        buttonsSetingsAndInfo.add(Arrays.asList(InlineKeyboardButton.builder().text("Отримати інфо")
                                .callbackData("GET_INFO").build()));
                        buttonsSetingsAndInfo.add(Arrays.asList(InlineKeyboardButton.builder().text("Налаштування")
                                .callbackData("SETTINGS").build()));
                        execute(SendMessage.builder()
                                .text("Ласкаво просимо.Цей бот дозволить відслідкувати актуальні курси валют").
                                chatId(message.getChatId().toString())
                                .replyMarkup(InlineKeyboardMarkup.builder()
                                        .keyboard(buttonsSetingsAndInfo)
                                        .build())
                                .build());
                        return;
                }
            }
        }
    }

    public static ReplyKeyboardMarkup initKeyboard2() {
        ReplyKeyboardMarkup keyboard2 = new ReplyKeyboardMarkup();
        keyboard2.setResizeKeyboard(true);
        keyboard2.setOneTimeKeyboard(true);

        ArrayList<KeyboardRow> keyboardRows2 = new ArrayList<>();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRows2.add(keyboardRow2);
        keyboardRow2.add("111");
        keyboardRow2.add("Test4");
        keyboard2.setKeyboard(keyboardRows2);
        return keyboard2;
    }
}
