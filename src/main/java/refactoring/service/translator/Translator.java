package refactoring.service.translator;

import refactoring.model.buttonnames.Language;

import java.util.List;

public interface Translator {
    List<String> translate(Language language);
}
