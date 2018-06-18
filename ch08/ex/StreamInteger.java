package ch08.ex;

import java.util.*;
import java.util.stream.*;
import java.math.*;

public class StreamInteger {

    public static long powerN(long number, int power){
        long res = 1;
        long sq = number;
        while(power > 0){
            if(power % 2 == 1){
                res *= sq;
            }
            sq = sq * sq;
            power /= 2;
        }
        return res;
    }

    public static Long randomGenerator(Long prev) {
        Long mod = powerN(2, 48);
        Long a = 25214903917L;
        return (11L +  a * prev) % mod;
    }

    public static void main(String[] args) {
        // 8-3
        int[] values = {1,4,9,16};
        var s = Stream.of(values);
        Stream<BigInteger> ints = Stream.iterate(BigInteger.ZERO, i -> i.add(BigInteger.ONE));
        System.out.println(Arrays.asList(ints.limit(10).toArray()));
        // 8-4
        Long seed = 31L;
        var rands = Stream.iterate(seed, i -> randomGenerator(i));
        System.out.println(Arrays.asList(rands.limit(10).toArray()));
    }
}
