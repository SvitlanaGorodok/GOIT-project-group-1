import keyboards.MenuNumDecimalPlaces;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

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
        if (update.hasCallbackQuery()) {
            try {
                handleQuery(update.getCallbackQuery());
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void handleMessage(Message message) throws TelegramApiException {
        long chatId = message.getChatId();
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity;
            commandEntity = message.getEntities().stream()
                    .filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (commandEntity.isPresent()) {
                String command = message.getText()
                        .substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                switch (command) {
                    case "/start":
                        execute(SendMessage.builder()
                                .text("Ласкаво просимо.Цей бот дозволить відслідкувати актуальні курси валют")
                                .chatId(chatId)
                                .replyMarkup(keyboardMenuStart())
                                .build());
                }
            }
        }
    }

    private void handleQuery(CallbackQuery buttonQuery) throws TelegramApiException {
        long chatId = buttonQuery.getMessage().getChatId();
        String dataButtonQuery = buttonQuery.getData();
        System.out.println("dataButtonQuery "+dataButtonQuery);
        switch (dataButtonQuery) {
            case "SETTINGS":
                execute(SendMessage.builder()
                        .text("Налаштування")
                        .chatId(chatId)
                        .replyMarkup(keyboardMenuSettings())
                        .build());
                break;
            case "Currency":
                execute(SendMessage.builder()
                        .text("Вибиріть необхідну валюту:")
                        .chatId(chatId)
                        .replyMarkup(keyboardMenuCurrency())
                        .build());
                break;
        }
    }
    private static InlineKeyboardMarkup keyboardMenuCurrency() {
        List<List<InlineKeyboardButton>> keyboardMenuCurrency = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency4 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMenuCurrency5 = new ArrayList<>();
        InlineKeyboardButton buttonUsd = InlineKeyboardButton.builder()
                .text("USD")
                .callbackData("USD")
                .build();
        InlineKeyboardButton buttonEur = InlineKeyboardButton.builder()
                .text("EUR")
                .callbackData("EUR")
                .build();
        InlineKeyboardButton buttonPln = InlineKeyboardButton.builder()
                .text("PLN")
                .callbackData("PLN")
                .build();
        InlineKeyboardButton buttonBtc = InlineKeyboardButton.builder()
                .text("BITCOIN")
                .callbackData("BTC")
                .build();
        InlineKeyboardButton buttonBack = InlineKeyboardButton.builder()
                .text("Назад")
                .callbackData("SETTINGS")
                .build();
        keyboardMenuCurrency1.add(buttonUsd);
        keyboardMenuCurrency2.add(buttonEur);
        keyboardMenuCurrency3.add(buttonPln);
        keyboardMenuCurrency4.add(buttonBtc);
        keyboardMenuCurrency5.add(buttonBack);
        keyboardMenuCurrency.add(keyboardMenuCurrency1);
        keyboardMenuCurrency.add(keyboardMenuCurrency2);
        keyboardMenuCurrency.add(keyboardMenuCurrency3);
        keyboardMenuCurrency.add(keyboardMenuCurrency4);
        keyboardMenuCurrency.add(keyboardMenuCurrency5);
\
        return InlineKeyboardMarkup.builder().keyboard(keyboardMenuCurrency).build();
    }

    private static InlineKeyboardMarkup keyboardMenuStart() {

        List<List<InlineKeyboardButton>> keyboardMenuStart = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSRow2 = new ArrayList<>();
        InlineKeyboardButton buttonGetInfo = InlineKeyboardButton.builder()
                .text("Отримати інфо")
                .callbackData("GET_INFO")
                .build();
        InlineKeyboardButton buttonSettings = InlineKeyboardButton.builder()
                .text("Налаштування")
                .callbackData("SETTINGS")
                .build();
        keyboardMSRow1.add(buttonGetInfo);
        keyboardMSRow2.add(buttonSettings);
        keyboardMenuStart.add(keyboardMSRow1);
        keyboardMenuStart.add(keyboardMSRow2);
        return InlineKeyboardMarkup.builder().keyboard(keyboardMenuStart).build();
    }

    private static InlineKeyboardMarkup keyboardMenuSettings() {
        List<List<InlineKeyboardButton>> keyboardMenuSettings = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardMSetRow4 = new ArrayList<>();
        InlineKeyboardButton buttonNumOfDecPlaces = InlineKeyboardButton.builder()
                .text("Кількість знаків після коми")
                .callbackData("NumberOfDecimalPlaces")
                .build();
        InlineKeyboardButton buttonBank = InlineKeyboardButton.builder()
                .text("Банк")
                .callbackData("Bank")
                .build();
        InlineKeyboardButton buttonCurrency = InlineKeyboardButton.builder()
                .text("Валюта")
                .callbackData("Currency")
                .build();
        InlineKeyboardButton buttonNotificationTime = InlineKeyboardButton.builder()
                .text("Час сповіщення")
                .callbackData("NotificationTime")
                .build();
        keyboardMSetRow1.add(buttonNumOfDecPlaces);
        keyboardMSetRow2.add(buttonBank);
        keyboardMSetRow3.add(buttonCurrency);
        keyboardMSetRow4.add(buttonNotificationTime);
        keyboardMenuSettings.add(keyboardMSetRow1);
        keyboardMenuSettings.add(keyboardMSetRow2);
        keyboardMenuSettings.add(keyboardMSetRow3);
        keyboardMenuSettings.add(keyboardMSetRow4);

        return InlineKeyboardMarkup.builder().keyboard(keyboardMenuSettings).build();
    }

    private void printMenu(Long chatID, InlineKeyboardMarkup keyboard, String text)
            throws TelegramApiException {
        execute(SendMessage.builder()
                .text(text)
                .chatId(chatID)
                .replyMarkup(keyboard)
                .build());
    }

    private void printMessage(Long chatID, String messageText) throws TelegramApiException {
        execute(SendMessage.builder()
                .text(messageText)
                .chatId(chatID)
                .build());
    }
}



