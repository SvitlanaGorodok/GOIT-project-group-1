import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
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
        List<InlineKeyboardButton> buttons = List.of(
                createButton("buttonName1", "buttonText1"),
                createButton("buttonName2", "buttonText2"),
                createButton("buttonName3", "buttonText3"),
                createButton("buttonName4", "buttonText4"),
                createButton("buttonName5", "buttonText5"));
        createMenu(message, buttons, List.of(2, 2, 1));
        sendApiMethodAsync(message);
    }

    private SendMessage createMessage(String text, Long chatId) {
        return new SendMessage(chatId.toString(), text);
    }

    void createMenu(SendMessage message, List<InlineKeyboardButton> buttons, List<Integer> keyboadrView) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        int index = 0;
        for (Integer buttonsAmount : keyboadrView) {
            keyboard.add(buttons.subList(index, index + buttonsAmount));
            index += buttonsAmount;
        }
        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);
    }

    private InlineKeyboardButton createButton(String text, String callbackText) {
        return InlineKeyboardButton.builder()
                .text(text)
                .callbackData(callbackText)
                .build();
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
