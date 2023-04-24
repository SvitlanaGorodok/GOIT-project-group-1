import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
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
        SendMessage message = createMessage("Hello", chatId);
//        createMenu(message);
        ReplyKeyboardMarkup replyKeyboardMarkup = createMenu(List.of("BTN1", "BTN2", "BTN3", "BTN4", "BTN5"), 2);
        message.setReplyMarkup(replyKeyboardMarkup);
        sendApiMethod(message);
    }

    private SendMessage createMessage(String text, Long chatId){
        return new SendMessage(chatId.toString(), text);
    }

    private void createMenu(SendMessage message){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardButton keyboardButton = new KeyboardButton("BTN 1");
        keyboardRow.add(keyboardButton);
        replyKeyboardMarkup.setKeyboard(List.of(keyboardRow));
        replyKeyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(replyKeyboardMarkup);
    }

    private ReplyKeyboardMarkup createMenu(List<String> buttonsList, int buttonsAmountInRow){
        int rowsAmount = buttonsList.size() / buttonsAmountInRow + 1;
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //IntStream?
        for (int i = 0; i < rowsAmount; i++) {
            keyboardRows.add(new KeyboardRow());
        }
        int counter = 0;
        int rowNumber = 1;
        for (KeyboardRow keyboardRow : keyboardRows) {
            for (int i = counter; i < buttonsAmountInRow * rowNumber; i++) {
                if (counter < buttonsList.size()){
                    keyboardRow.add(buttonsList.get(counter));
                }
                counter++;
            }
            rowNumber++;
        }
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
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
