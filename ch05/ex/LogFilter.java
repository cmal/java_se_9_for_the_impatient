package ch05.ex;

import java.util.logging.*;

public class LogFilter implements Filter {
    public boolean isLoggable(LogRecord record) {
        String msg = record.getMessage();
        return msg.indexOf("sex") == -1 &&
            msg.indexOf("drugs") == -1 &&
            msg.indexOf("C++") == -1;
    }
}
