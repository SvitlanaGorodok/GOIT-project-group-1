import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CurrencyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "@CurrencyInfoProjectGroup1TestBot";
    }

    @Override
    public String getBotToken() {
        return "5553351040:AAHugdZyMWm_u8av-bQqsEaP6Et7WXPsOtk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);
        SendMessage message = createMessage("Hello", chatId);
        createMenu(List.of("BTN1", "BTN2", "BTN3", "BTN4", "BTN5"), 2, message);
        sendApiMethodAsync(message);

    }

    private SendMessage createMessage(String text, Long chatId) {
        return new SendMessage(chatId.toString(), text);
    }

    private void createMenu(List<String> buttonsList, int buttonsAmountInRow, SendMessage message) {
        if (buttonsAmountInRow > 0) {
            int rowsAmount = buttonsList.size() % buttonsAmountInRow == 0 ?
                    buttonsList.size() / buttonsAmountInRow :
                    buttonsList.size() / buttonsAmountInRow + 1;
            List<KeyboardRow> keyboardRows = IntStream.range(1, rowsAmount + 1)
                    .mapToObj(i -> new KeyboardRow())
                    .collect(Collectors.toList());

            int rowNumber = 1;
            for (KeyboardRow keyboardRow : keyboardRows) {
                int counter = (rowNumber - 1) * buttonsAmountInRow;
                while (counter < buttonsAmountInRow * rowNumber) {
                    if (counter < buttonsList.size()) {
                        keyboardRow.add(buttonsList.get(counter));
                        counter++;
                    } else {
                        break;
                    }
                }
                rowNumber++;
            }

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(keyboardRows);
            replyKeyboardMarkup.setResizeKeyboard(true);
            message.setReplyMarkup(replyKeyboardMarkup);
        }
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
