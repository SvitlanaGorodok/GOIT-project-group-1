import keyboards.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import settings.Banks;
import settings.NotificationTime;
import settings.NumberOfDecimalPlaces;

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
                if (command.equals("/start")) {
                    printMessage(chatId, MenuStart.keyboard(),
                            "Ласкаво просимо.Цей бот дозволить відслідкувати актуальні курси валют.");
                }
            }
        } else {
            printMessage(chatId, "Будь ласка впишіть /start або натисніть кнопку.");
        }
    }

    private void handleQuery(CallbackQuery buttonQuery) throws TelegramApiException {
        long chatId = buttonQuery.getMessage().getChatId();
        String dataButtonQuery = buttonQuery.getData();
        switch (dataButtonQuery) {
            case "GET_INFO":
                printMessage(chatId, "Bank \n currency buy: \n currency sell:");
                break;
            case "SETTINGS":
            case "BackToSettings":
                printMessage(chatId, MenuSettings.keyboard(), "Виберіть налаштування");
                break;
            case "BackToStart":
                printMessage(chatId, MenuStart.keyboard(), "Щоб отримати інфо натисність кнопку");
                break;
            case "NumDecimalPlaces":
                updateMessage(buttonQuery, MenuNumDecimalPlaces.keyboard());
                break;
            case "Bank":
                updateMessage(buttonQuery, MenuBanks.keyboard());
                break;
            case "Currency":
                updateMessage(buttonQuery, MenuCurrency.keyboard());
                break;
            case "Notification":
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "Privat":
                saveSelectBanks(Banks.PRIVATE);
                updateMessage(buttonQuery, MenuBanks.keyboard());
                break;
            case "NBU":
                saveSelectBanks(Banks.NBU);
                updateMessage(buttonQuery, MenuBanks.keyboard());
                break;
            case "Monobank":
                saveSelectBanks(Banks.MONO);
                updateMessage(buttonQuery, MenuBanks.keyboard());
                break;
            case "twoPlaces":
                saveSelectNumDecPlaces(NumberOfDecimalPlaces.TWO);
                updateMessage(buttonQuery, MenuNumDecimalPlaces.keyboard());
                break;
            case "threePlaces":
                saveSelectNumDecPlaces(NumberOfDecimalPlaces.THREE);
                updateMessage(buttonQuery, MenuNumDecimalPlaces.keyboard());
                break;
            case "fourPlaces":
                saveSelectNumDecPlaces(NumberOfDecimalPlaces.FOUR);
                updateMessage(buttonQuery, MenuNumDecimalPlaces.keyboard());
                break;
            case "9":
                saveSelectNotificationTime(NotificationTime.NINE);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "10":
                saveSelectNotificationTime(NotificationTime.TEN);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "11":
                saveSelectNotificationTime(NotificationTime.ELEVEN);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "12":
                saveSelectNotificationTime(NotificationTime.TWELVE);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "13":
                saveSelectNotificationTime(NotificationTime.THIRTEEN);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "14":
                saveSelectNotificationTime(NotificationTime.FOURTEEN);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "15":
                saveSelectNotificationTime(NotificationTime.FIFTEEN);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "16":
                saveSelectNotificationTime(NotificationTime.SIXTEEN);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "17":
                saveSelectNotificationTime(NotificationTime.SEVENTEEN);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "18":
                saveSelectNotificationTime(NotificationTime.EIGHTEEN);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
            case "0":
                saveSelectNotificationTime(NotificationTime.SWICH_OFF);
                updateMessage(buttonQuery, MenuNotification.keyboard());
                break;
        }
    }

    private void saveSelectNumDecPlaces(NumberOfDecimalPlaces enumDate) {
        for (NumberOfDecimalPlaces date : NumberOfDecimalPlaces.values()) {
            if (date.name().equals(enumDate.name())) {
                enumDate.setSelect(true);
            } else {
                date.setSelect(false);
            }
        }
    }

    private void saveSelectNotificationTime(NotificationTime enumDate) {
        for (NotificationTime date : NotificationTime.values()) {
            if (date.name().equals(enumDate.name())) {
                enumDate.setSelect(true);
            } else {
                date.setSelect(false);
            }
        }
    }

    private void saveSelectBanks(Banks enumDate) {
        for (Banks date : Banks.values()) {
            if (date.name().equals(enumDate.name())) {
                enumDate.setSelect(true);
            } else {
                date.setSelect(false);
            }
        }
    }

    private void printMessage(Long chatID, InlineKeyboardMarkup keyboard, String text)
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

    private void updateMessage(CallbackQuery buttonQuery, InlineKeyboardMarkup keyboard)
            throws TelegramApiException {
        long chatId = buttonQuery.getMessage().getChatId();
        int messageId = buttonQuery.getMessage().getMessageId();
        execute(EditMessageReplyMarkup.builder()
                .chatId(chatId)
                .messageId(messageId)
                .replyMarkup(keyboard)
                .build());
    }

//Приклад використання енамів для друкування галочки
//    public static InlineKeyboardMarkup testKeyboard() {
//        List<List<InlineKeyboardButton>> keyboardMenuSettings = new ArrayList<>();
//        List<InlineKeyboardButton> keyboardMSetRow1 = new ArrayList<>();
//
//        InlineKeyboardButton buttonNumOfDecPlaces = InlineKeyboardButton.builder()
//                .text("Кількість знаків після коми" + Test.getButtonStatus(Test.BUTTON1))
//                .callbackData("NumDecimalPlaces")
//                .build();
//        keyboardMSetRow1.add(buttonNumOfDecPlaces);
//
//        keyboardMenuSettings.add(keyboardMSetRow1);
//
//        return InlineKeyboardMarkup.builder().keyboard(keyboardMenuSettings).build();
//    }

    //Приклад методу перевірки статусу кнопки і друкування галочки
//    public static String getButtonStatus (Test button){
//        if(button.isStatus()){
//            return "✅";
//        }
//        return "";
//    }
}


