package ch02.ex;

import static java.lang.System.out;
import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class ChangeCalendarStatic {
    public static void main(String[] args) {

        // out.println(" Sun Mon Tue Wed Thu Fri Sat");
        out.println(" 日 一 二 三 四 五 六");
        LocalDate now = now();
        int year = now.getYear();
        int month = now.getMonthValue();
        LocalDate date = of(year, month, 1);
        int value = date.getDayOfWeek().getValue();
        for (int i = 0; i < value; i ++) {
            // out.print("    ");
            out.print("   ");
        }
        while (date.getMonthValue() == month) {
            // out.printf("%4d", date.getDayOfMonth());
            out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue() == 6) {
                out.println();
            }
            date = date.plusDays(1);
        }
        return;
    }
}
