package ch05.ex;

import java.util.logging.*;
import ch05.ex.LogFilter;
import ch05.ex.LogFormatter;
import java.io.IOException;

public class TestLogger {
    public static void main(String[] args) {

        try {
            LogFilter filter = new LogFilter();
            LogFormatter formatter = new LogFormatter();
            Logger logger = Logger.getGlobal();
            logger.setFilter(filter);
            // DO NOT NEED THESE:
            // Handler[] handlers = logger.getHandlers();
            // for(Handler handler : handlers) {
            //     logger.removeHandler(handler);
            // }
            logger.setUseParentHandlers(false);
            FileHandler handler = new FileHandler("TestLogger.log");
            handler.setFormatter(formatter);
            logger.addHandler(handler);
            logger.info("Hello Yu!");
            logger.info("Hello sex!");
            logger.info("Hello C++!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
