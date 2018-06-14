package ch04.ex;

public class EnumColor {
    public enum Color {
        BLACK,
        RED,
        BLUE,
        GREEN,
        CYAN,
        MAGENTA,
        YELLOW,
        WHITE;

        public static Color getBlue() {
            return BLUE;
        }
        public static Color getRed() {
            return RED;
        }
        public static Color getGreen() {
            return GREEN;
        }
    }

    public static void main(String[] args) {
        System.out.println(Color.getBlue());
        System.out.println(Color.getRed());
        System.out.println(Color.getGreen());
    }
}
