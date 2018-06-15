package ch05.ex;

public class Factorial {
    public static int factorial(int n) throws Exception {
        if (n == 1) {
            throw new Exception("Nothing");
        }
        return factorial(n - 1);
    }

    public static void main(String[] args) {
        try {
            factorial(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
