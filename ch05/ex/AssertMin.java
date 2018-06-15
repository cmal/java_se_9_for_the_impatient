package ch05.ex;

public class AssertMin {

    private static void assertLe(int minValue, int value) {
        assert minValue <= value;
    }

    public static int min(int[] values) {
        int minValue = Integer.MAX_VALUE;
        for (int i : values) {
            if (minValue > i) {
                minValue = i;
            }
        }

        for (int i : values) {
            assertLe(minValue, i);
        }

        return minValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i ++) {
            arr[i] = i;
        }
        long startTime = System.currentTimeMillis();
        System.out.println(min(arr));
        long endTime = System.currentTimeMillis();
        System.out.printf("Run time: %s ms.", endTime - startTime);
        // 95ms with assertion enabled
        // 49ms with assertion disabled
        // 43ms without assertion
    }
}

