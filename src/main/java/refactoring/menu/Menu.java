package refactoring.menu;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Menu {
    public void printMenu();

    default void createMenu(List<String> buttonsList, int buttonsAmountInRow, SendMessage message) {
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
}
