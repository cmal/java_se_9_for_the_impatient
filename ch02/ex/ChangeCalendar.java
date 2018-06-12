package ch02.ex;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class ChangeCalendar {
    public static void main(String[] args) {

        // System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        System.out.println(" 日 一 二 三 四 五 六");
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        LocalDate date = LocalDate.of(year, month, 1);
        int value = date.getDayOfWeek().getValue();
        for (int i = 0; i < value; i ++) {
            // System.out.print("    ");
            System.out.print("   ");
        }
        while (date.getMonthValue() == month) {
            // System.out.printf("%4d", date.getDayOfMonth());
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue() == 6) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
        return;
    }
}
