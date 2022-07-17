package settings;

public class Setting {

    private final long chatId;

    public Setting(long chatId) {
        this.chatId = chatId;
    }



    private NumberOfDecimalPlaces numberOfDecimalPlaces = NumberOfDecimalPlaces.TWO;
    private Banks selectedBank = Banks.PRIVAT;
    private Currency selectedCurrency = Currency.USD;
    private NotificationTime notificationTime = NotificationTime.NINE;

    public long getChatId() {
        return chatId;
    }

    public int getNumberOfDecimalPlaces() {
        return numberOfDecimalPlaces.getIntNumber();
    }

    public void setNumberOfDecimalPlaces(NumberOfDecimalPlaces numberOfDecimalPlaces) {
        this.numberOfDecimalPlaces = numberOfDecimalPlaces;
    }

    public Banks getSelectedBank() {
        return selectedBank;
    }

    public void setSelectedBank(Banks selectedBank) {
        this.selectedBank = selectedBank;
    }

    public Currency getSelectedCurrency() {
        return selectedCurrency;
    }

    public void setSelectedCurrency(Currency selectedCurrency) {
        this.selectedCurrency = selectedCurrency;
    }

    public NotificationTime getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(NotificationTime notificationTime) {
        this.notificationTime = notificationTime;
    }
}
