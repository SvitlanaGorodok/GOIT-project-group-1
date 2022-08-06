package settings;

public enum Language {
    EN("English", "\uD83C\uDDFA\uD83C\uDDF8"),
    UA("Ukrainian", "\uD83C\uDDFA\uD83C\uDDE6");

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
        if (language == UA){
            return text;
        } else if (language == EN){
            switch (text){
                case "Курс купівлі ":
                    return "Purchase fx rate ";
                case "Курс продажу ":
                    return "Sales fx rate ";
                case "немає купівлі":
                    return "no purchase";
                case "немає продажу":
                    return "no sale";
                case "Будь ласка впишіть /start або натисніть кнопку.":
                    return "Please type /start or press the button.";
                case "Щоб отримати інфо натисність кнопку":
                    return "For get info please press the button";
                case "Виберіть налаштування":
                    return "Please choose options";
                case "Ласкаво просимо. Цей бот дозволить відслідкувати актуальні курси валют":
                    return "Welcome. This bot will help you to follow up current fx rates.";
            }
        }
        return "";
    }
}
