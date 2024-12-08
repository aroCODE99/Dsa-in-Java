class Counter {
    static int count = 0; // Static variable

    // Static method
    void increment() {
        count++;
    }
}

public class WhatIsStatic {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        counter1.increment();

        Counter counter2 = new Counter();
        counter2.increment();

        System.out.println(Counter.count); // Output: 2
    }
}

// Why this is problematic:

// Both counter1 and counter2 are sharing the same count value. Even though they
// are different objects, they share the same static variable, which can lead to
// confusion and errors.
//
//
// Meaning it is not shared to indiviual its a class thing, (like a global thing
// to all classes).
