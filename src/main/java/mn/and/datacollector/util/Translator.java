package mn.and.datacollector.util;

import java.util.Locale;
import java.util.ResourceBundle;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;

@RequestScoped
public class Translator {

  @Context
  HttpHeaders headers;

  public String translate(String keyword) {

    try {
      Locale locale = headers.getAcceptableLanguages().stream().findFirst().orElse(Locale.ENGLISH);
      return ResourceBundle.getBundle("messages/msg", locale).getString(keyword);
    } catch (Exception e) {
      return keyword;
    }
  }

  public String translate(String keyword, Object... args) {

    try {
      String translated = translate(keyword);
      return args != null ? String.format(translated, args) : translated;
    } catch (Exception e) {
      return keyword;
    }
  }

  public boolean isMessageEmpty(String message) {
    return message == null || message.isBlank();
  }
}
