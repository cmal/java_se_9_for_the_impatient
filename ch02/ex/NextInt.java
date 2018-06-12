package ch02.ex;


public class NextInt {
    public static void main(String[] args) {
        System.out.println("In my own opinion: ");
        System.out.println("nextInt() of Scanner is a Mutator");
        System.out.println("Because it will change the return value of hasNext()");
        System.out.println("nextInt() of Scanner is a Mutator, too.");
        System.out.println("Because it will change the return value of nextInt(), nextFloat(), nextLong(), even if we setSeed().");
    }
}
