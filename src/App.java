import edu.princeton.cs.algs4.RedBlackBST;
import java.util.Scanner;
import java.util.Stack;
import java.util.Calendar;

public class App {
    public static void main(String[] args) throws Exception {
        RedBlackBST redBlackBST = new RedBlackBST<>();

        redBlackBST.put("09:00:00", "Chicago");
        redBlackBST.put("09:00:03", "Phoenix");
        redBlackBST.put("09:00:13", "Houston");
        redBlackBST.put("09:00:59", "Chicago");
        redBlackBST.put("09:01:10", "Houston");
        redBlackBST.put("09:03:13", "Chicago");
        redBlackBST.put("09:10:11", "Seattle");
        redBlackBST.put("09:10:25", "Seattle");
        redBlackBST.put("09:14:25", "Phoenix");

        // reroute(redBlackBST, "09:00:00", "Copenhagen");
        // cancel(redBlackBST, "09:00:00");
        // destination(redBlackBST, "09:00:00");

        // Expected 09:00:24 - works
        changeTime("09:00:00", 24);

        // Expected 09:01:23
        changeTime("09:00:00", 83);

        // Expected 10:14:25
        changeTime("09:14:25", 3600);
    }

    // Works
    public static void cancel(RedBlackBST redBlackBST, String s) {
        redBlackBST.delete(s);
    }

    // TODO
    public static void delay(RedBlackBST redBlackBST, String s) {
        redBlackBST.delete(s);
    }

    // Works
    public static void reroute(RedBlackBST redBlackBST, String s, String c) {
        redBlackBST.put(s, c);
    }

    // Works
    public static void destination(RedBlackBST redBlackBST, String s) {
        System.out.println(redBlackBST.get(s));
    }

    // Helper function that should be able to convert increase and decrease time
    public static void changeTime(String time, int delayInSeconds) {

        // Seperate by :
        String[] timeSplitted = time.split(":");
        // Convert into int
        int hours = Integer.parseInt(timeSplitted[0]);
        int minutes = Integer.parseInt(timeSplitted[1]);
        int seconds = Integer.parseInt(timeSplitted[2]);

        seconds += delayInSeconds;

        // // Do calculation
        if (seconds >= 60) {
            minutes += (seconds / 60);
            seconds = seconds - 60;
        }
        if (minutes >= 60) {
            hours += (minutes / 60);
            minutes = minutes - 60;
        }
        if (hours >= 24) {
            hours = 0;
        }

        String secondsOutput = String.valueOf(seconds);
        if (secondsOutput.length() == 1)
            secondsOutput = "0" + seconds;

        String minutesOutput = String.valueOf(minutes);
        if (minutesOutput.length() == 1)
            minutesOutput = "0" + minutes;

        String hoursOutput = String.valueOf(hours);
        if (hoursOutput.length() == 1)
            hoursOutput = "0" + hours;

        // Convert into string again
        String output = hoursOutput + ":" + minutesOutput + ":" + secondsOutput;
        System.out.println(output);
    }

}
