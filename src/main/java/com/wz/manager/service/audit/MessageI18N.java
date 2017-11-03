package com.wz.manager.service.audit;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageI18N {
    private final String baseName;
    private final ResourceBundle rb;

    public MessageI18N(String baseName) {
        this.baseName = baseName;
        final String lang = System.getenv("LANG");
        this.rb = (lang != null && !lang.contains("en_US")
                   && lang.length() >= 5)
                ? ResourceBundle.getBundle(this.baseName,
                new Locale(lang.substring(0, 2), lang.substring(3, 5)))
                : ResourceBundle.getBundle(this.baseName);
    }

    public String msg(String key, String... values) {
        try {
            final String msg = this.rb.getString(key);
            return (values == null || values.length == 0)
                    ? msg : new MessageFormat(msg).format(values);
        } catch (Exception e) {
            return null;
        }
    }
}