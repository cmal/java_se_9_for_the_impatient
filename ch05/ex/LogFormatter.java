package ch05.ex;

import java.util.logging.*;

public class LogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return "<html lang=" +
            "\"" + "en" + "\"" +
            "><head><meta charset=" + "\"" + "utf-8" + "\"" + "><meta content=" +
            "\"" + "IE=edge,chrome=1" + "\"" + "http-equiv=" + "\"" + "X-UA-Compatible" +
            "\"" + "><title></title></head><body>"
            + record.getMessage()
            + "</body></html>";
    }

}
