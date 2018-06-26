package ch10.ex;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class EscapingThis {
    // Produce an example that demonstrates escaping of this in a
    // constructor of an immutable class (see Section 10.3.3,
    // “Strategies for Safe Concurrency,” page 346). Try to come up
    // with something convincing and scary. If you use an event
    // listener (as many examples on the Web do), it should listen for
    // something interesting, which isn't easy for an immutable class.

    // refer to this:
    // https://wiki.sei.cmu.edu/confluence/display/java/TSM01-J.+Do+not+let+the+this+reference+escape+during+object+construction

    // TODO
    public static EscapingThis ethis;
    final int num; // make this class immutable
    private EscapingThis(int number) {
        ethis = this; // ethis may escaping
        this.num = number;
    }

    public int getNum() {
        return this.num;
    }

    public static EscapingThis newInstance(int number) {
        EscapingThis et = new EscapingThis(number);
        return et;
    }

    public class WorkerThread extends Thread {
        @Override
        public void run() {
            
        }
    }

    public static void main(String[] args) {
        
    }
}

