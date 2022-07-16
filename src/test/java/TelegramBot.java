import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

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
//            System.out.println(update.getCallbackQuery());
//            System.out.println("111111111111111111111111");
//            System.out.println(update.getMessage());
//            System.out.println(update.getMessage().getChatId());
//            System.out.println(update.getCallbackQuery().getFrom().getId());
//
//            System.out.println(update.getCallbackQuery().getChatInstance());
            String sss = update.getCallbackQuery().getData();
            SendMessage ssss = new SendMessage();
            ssss.setChatId(update.getCallbackQuery().getFrom().getId());
            ssss.setText(sss);
            try {
                execute(ssss);
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
                sendMess.setReplyMarkup(initKeyboard(update));
//                }
                execute(sendMess);
            }


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    private InlineKeyboardMarkup initKeyboard(Update update) {

        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();

        List<InlineKeyboardButton> keyboardRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardRow2 = new ArrayList<>();

        InlineKeyboardButton test1 = InlineKeyboardButton.builder().text("Test1").callbackData("Test1").build();
        InlineKeyboardButton test2 = InlineKeyboardButton.builder().text("Test2").callbackData("Test2").build();
        keyboardRow1.add(test1);
        keyboardRow1.add(test2);

        keyboardRows.add(keyboardRow1);


        InlineKeyboardButton test3 = InlineKeyboardButton.builder().text("Test3").callbackData("Test3").build();
        InlineKeyboardButton test4 = InlineKeyboardButton.builder().text("Test4").callbackData("Test4").build();
        keyboardRow2.add(test3);
        keyboardRow2.add(test4);
        keyboardRows.add(keyboardRow2);


        return InlineKeyboardMarkup.builder().keyboard(keyboardRows).build();
    }

    private ReplyKeyboardMarkup initKeyboard2() {
        ReplyKeyboardMarkup keyboard2 = new ReplyKeyboardMarkup();
        keyboard2.setResizeKeyboard(true);
        keyboard2.setOneTimeKeyboard(true);

        ArrayList<KeyboardRow> keyboardRows2 = new ArrayList<>();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRows2.add(keyboardRow2);
        keyboardRow2.add("Test3");
        keyboardRow2.add("Test4");
        keyboard2.setKeyboard(keyboardRows2);
        return keyboard2;
    }
}
