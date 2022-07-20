package settings;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "TestKabaBOT";
    }

    @Override
    public String getBotToken() {
        return "5110494726:AAHvvtZ2yxM8dnzpR730WBz4eeG7haGp9Kw";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()) {
            long chatID = update.getCallbackQuery().getFrom().getId();

            Setting setting = new Setting(chatID);
            Settings.settings.put(chatID, setting);

            String sss = update.getCallbackQuery().getData();
            SendMessage mess = new SendMessage();
            mess.setChatId(chatID);
            mess.setText(sss);
            mess.setReplyMarkup(initKeyboard2(setting));
            try {
                execute(mess);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }


        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMess = update.getMessage();
                Long chatId = inMess.getChatId();

                SendMessage sendMess = new SendMessage();
                sendMess.setChatId(chatId);

//                if (up) {
//                    sendMess.setText("Вы перешли в меню кнопочки test1");
//                    sendMess.setReplyMarkup(initKeyboard());
//
//                } else {
                sendMess.setText("ID чата " + chatId);
                sendMess.setReplyMarkup(initKeyboard());
//                }
                execute(sendMess);
            }


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    private InlineKeyboardMarkup initKeyboard() {

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();

        List<InlineKeyboardButton> keyboardRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardRow2 = new ArrayList<>();

        InlineKeyboardButton getInfoButton = InlineKeyboardButton.builder()
                .text("Отрмати інфо").callbackData("GET_INFO")
                .build();
        InlineKeyboardButton settingsButton = InlineKeyboardButton.builder()
                .text("Налаштування").callbackData("SETTINGS")
                .build();
        keyboardRow1.add(getInfoButton);
        keyboardRow2.add(settingsButton);

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);

        return InlineKeyboardMarkup.builder().keyboard(keyboardRows).build();
    }

    private InlineKeyboardMarkup initKeyboard2(Setting setting) {
        String selectedCurr = setting.getSelectedCurrency().stream()
                .map(Currency::getCurrencyName)
                .collect(Collectors.joining(", ", "(", ")"));

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();

        List<InlineKeyboardButton> keyboardRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardRow3 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardRow4 = new ArrayList<>();

        InlineKeyboardButton numberOfDecPlacesButton = InlineKeyboardButton.builder()
                .text("Кількість знаків після коми" + " (" + setting.getNumberOfDecimalPlaces() + ")")
                .callbackData("SELECTED_NUMBER_OF_DEC_PLACES")
                .build();
        InlineKeyboardButton BankButton = InlineKeyboardButton.builder()
                .text("Банк" + " (" + setting.getSelectedBank().getBankNameUA() + ")")
                .callbackData("SELECTED_BANK")
                .build();
        InlineKeyboardButton CurrencyButton = InlineKeyboardButton.builder()
                .text("Валюти " + selectedCurr)
                .callbackData("SELECTED_CURRENCY")
                .build();
        InlineKeyboardButton NotificationTimeButton = InlineKeyboardButton.builder()
                .text("Час сповіщення" + " (" + setting.getNotificationTime().getTime() + ")")
                .callbackData("SELECTED_NOTIFICATION_TIME")
                .build();

        keyboardRow1.add(numberOfDecPlacesButton);
        keyboardRow2.add(BankButton);
        keyboardRow3.add(CurrencyButton);
        keyboardRow4.add(NotificationTimeButton);

        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);
        keyboardRows.add(keyboardRow3);
        keyboardRows.add(keyboardRow4);

        return InlineKeyboardMarkup.builder().keyboard(keyboardRows).build();
    }
}
