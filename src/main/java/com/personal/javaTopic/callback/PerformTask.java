package com.personal.javaTopic.callback;

public class PerformTask {
/*
 * A callback function in java is a way to pass a function as an argument to another function.  
 *  
 */

    public static void performSomeTask(int value, Callback callback) {
        System.out.println("Performing a task with value : " + value);
        callback.onComplete();
    }

    static Callback callback = () -> {
        System.out.println("Callback method executed !!! ");
    };

    public static void main(String[] args) {
        performSomeTask(100, callback);
    }
    //Just a fun comment

}
