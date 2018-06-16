package ch06.ex;

public class Arrays {
    // public static <T> void swap(T[] array, int i, int j) {
    //     T temp = array[i];
    //     array[i] = array[j];
    //     array[j] = temp;
    // }

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static void main(String[] args) {
        // String[] friends = new String[]{"A", "B", "C"};
        // Arrays.swap(friends, 0, 1);
        // System.out.printf("%s, %s, %s", friends[0], friends[1], friends[2]);
        Double[] result = Arrays.<Double>swap(0, 1, 1.5, 2.0, 3.0);
        System.out.printf("%f, %f, %f", result[0], result[1], result[2]);
    }
}
