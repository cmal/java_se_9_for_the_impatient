// In Java 7, implement a class DigitSequence that implements
// Iterator<Integer>, not IntSequence. Provide methods hasNext, next,
// and a do-nothing remove. Write a program that prints the elements
// of an instance.

// In Java 8, the Iterator class gained another method,
// forEachRemaining.

// Does your code still compile when you switch to Java 8? YES!

// If you put your Java 7 class in a JAR file and don't recompile,
// does it work in Java 8? YES!

// What if you call the forEachRemaining method? JAVA 8 WORKS.

// Also, the remove method has become a default method in
// Java 8, throwing an UnsupportedOperationException. What happens
// when remove is called on an instance of your class?
// NOTHING HAPPENS!

// in ~/gits/java_se_9_for_the_impatient/ folder
// $ jar cvf ch03.jar ch03/*
// $ java -cp ch03.jar ch03.ex.DigitSequence
// switch to JAVA 8
// $ java -cp ch03.jar ch03.ex.DigitSequence

package ch03.ex;

import java.util.Iterator;
    
public class DigitSequence implements Iterator<Integer> {

    private int cursor = 0;
    
    public Integer next() {
        return cursor * 2;
    }

    public boolean hasNext() {
        if (cursor++ >= 5) {
            return false;
        }
        return true;
    }

    public void remove() {
        
    }

    public static void main(String[] args) {
        DigitSequence ds = new DigitSequence();

        
        // while(ds.hasNext()) {
        //     ds.remove();
        //     System.out.println(ds.next());
        // }
        ds.forEachRemaining(System.out::println);
    }
}
