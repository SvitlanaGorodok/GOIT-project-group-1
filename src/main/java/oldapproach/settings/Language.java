package oldapproach.settings;

public enum Language {
    EN("English", "English \uD83C\uDDFA\uD83C\uDDF8"),
    UA("Ukrainian", "Українська \uD83C\uDDFA\uD83C\uDDE6"),
    PL("Polish", "Polski \uD83C\uDDF5\uD83C\uDDF1"),
    CZ ("Czech", "Čeština 🇨🇿"),
    RU ("Russian", "Русский \uD83C\uDDF7\uD83C\uDDFA");

    String langName;

    String langFlag;

    Language(String langName, String langFlag) {
        this.langName = langName;
        this.langFlag = langFlag;
    }

    public String getLangName() {
        return langName;
    }

    public String getLangFlag() {
        return langFlag;
    }

    public static Language convertToEnum(String text) {
        for (Language lang : Language.values()) {
            if (lang.getLangName().equals(text)) {
                return lang;
            }
        }
        return null;
    }

    public static String translate(String text, Language language) {
        switch (text){
            case "Курс купівлі ":
                switch (language){
                    case EN: return "Purchase fx rate ";
                    case PL: return "Kurs kupna ";
                    case CZ: return "Sazba nákupu ";
                    default: return text;
                }
            case "Курс продажу ":
                switch (language){
                    case EN: return "Sales fx rate ";
                    case PL: return "Kurs sprzedaży ";
                    case CZ: return "Prodejní sazba ";
                    default: return text;
                }
            case "немає купівлі":
                switch (language){
                    case EN: return "no purchase";
                    case PL: return "brak zakupu";
                    case CZ: return "žádný nákup";
                    default: return text;
                }
            case "немає продажу":
                switch (language){
                    case EN: return "no sale";
                    case PL: return "brak sprzedaży";
                    case CZ: return "žádný prodej";
                    default: return text;
                }
            case "Будь ласка впишіть /start або натисніть кнопку.":
                switch (language){
                    case EN: return "Please type /start or press the button.";
                    case PL: return "Proszę wpisz /start lub naciśnij klawisz.";
                    case CZ: return "Zadejte /start nebo stiskněte tlačítko.";
                    default: return text;
                }
            case "Щоб отримати інфо натисність кнопку":
                switch (language){
                    case EN: return "For get info please press the button";
                    case PL: return "Aby uzyskać informację naciśnij klawisz";
                    case CZ: return "Pro získání informací stiskněte prosím tlačítko";
                    default: return text;
                }
            case "Виберіть налаштування":
                switch (language){
                    case EN: return "Please choose options";
                    case PL: return "Proszę wybrać preferowane ustawienia";
                    case CZ: return "Vyberte prosím preferovaná nastavení";
                    default: return text;
                }
            case "Ласкаво просимо. Цей бот дозволить відслідкувати актуальні курси валют.":
                switch (language){
                    case EN: return "Welcome. This bot will help you to follow up current fx rates.";
                    case PL: return "Witamy. Ten bot pomoże śledzić aktualne kursy walut.";
                    case CZ: return "Vítejte. Tento bot vám pomůže sledovat aktuální směnné kurzy.";
                    default: return text;
                }
        }
        return "";
    }
}
