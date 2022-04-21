import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Debugging
        boolean debugScannerFlights = false;
        boolean debugScannerOperations = true;
        boolean debugDelay = false;
        boolean debugDestination = false;
        boolean debugReroute = false;
        boolean debugFinal = false;

        // Used for debugging
        ArrayList arr = new ArrayList<String>();
        ArrayList arr2 = new ArrayList<String>();

        RedBlackBST redBlackBST = new RedBlackBST<>();

        // Scanner
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String flight = scanner.nextLine();
            String[] parts = flight.split("\\s");
            String time = parts[0];
            String destination = parts[1];
            redBlackBST.put(time, destination);
            if (debugScannerFlights) {
                arr2.add(flight);
            }
        }

        for (int j = 0; j < m; j++) {
            String operations = scanner.nextLine();
            operationsRouter(redBlackBST, operations, arr);
        }

        scanner.close();

        if (debugScannerFlights) {
            // Expected
            // 09:00:00 Chicago
            // 09:00:03 Phoenix
            // 09:00:13 Houston
            // 09:00:59 Chicago
            // 09:01:10 Houston
            // 09:03:13 Chicago
            // 09:10:11 Seattle
            // 09:10:25 Seattle
            // 09:14:25 Phoenix
            // 09:19:32 Chicago
            // 09:19:46 Chicago
            // 09:21:05 Chicago
            // 09:22:43 Seattle
            // 09:22:54 Seattle
            System.out.println("------------------");
            for (int i = 0; i < arr2.size(); i++) {
                System.out.println(arr2.get(i));
            }
            System.out.println("------------------");
        }
        if (debugDelay) {

            // Expected 09:00:24 - works
            delay(redBlackBST, "09:00:00", "24");

            // Expected 10:14:25
            delay(redBlackBST, "09:14:25", "3600");

            // Expected Phoenix - Works (checks if we actually changed the time of the
            // flight above)
            destination(redBlackBST, "10:14:25");
        }
        if (debugDestination) {
            // Expected Chicago - works
            System.out.println("-" + destination(redBlackBST, "09:21:05") + "-");
        }
        if (debugReroute) {
            // Expected Houston - works
            reroute(redBlackBST, "09:21:05", "Houston");
            System.out.println("-" + destination(redBlackBST, "09:21:05") + "-");
        }
        if (debugFinal) {
            // Phoenix
            // -
            // Phoenix
            // -
            // -
            // Chicago
            // Houston
            System.out.println("------------------");
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == null)
                    // Note we need to move the "-" somewhere else
                    System.out.println("-");
                else
                    System.out.println(arr.get(i));
            }
            System.out.println("------------------");
        }
    }

    // Works
    public static void cancel(RedBlackBST redBlackBST, String s) {
        redBlackBST.delete(s);
    }

    public static void delay(RedBlackBST redBlackBST, String time, String delay) {

        String[] timeSplitted = time.split(":"); // We seperate the string by :

        // We convert the strings into int's
        int delayInSeconds = Integer.parseInt(delay);
        int hours = Integer.parseInt(timeSplitted[0]);
        int minutes = Integer.parseInt(timeSplitted[1]);
        int seconds = Integer.parseInt(timeSplitted[2]);

        Clock clock = new Clock(hours, minutes, seconds);
        clock.delayBySeconds(delayInSeconds);
        String newTime = clock.toString();

        String destination = (String) redBlackBST.get(time);
        redBlackBST.delete(time);
        redBlackBST.put(newTime, destination);
    }

    // Works
    public static void reroute(RedBlackBST redBlackBST, String s, String c) {
        redBlackBST.put(s, c);
    }

    // Works
    public static String destination(RedBlackBST redBlackBST, String s) {
        return (String) redBlackBST.get(s);

    }

    public static void operationsRouter(RedBlackBST redBlackBST, String input, ArrayList testArray) {

        String[] parts = input.split("\\s");
        String operation = parts[0];

        if (operation.equals("destination"))
            testArray.add(destination(redBlackBST, parts[1]));
        else if (operation.equals("cancel"))
            cancel(redBlackBST, parts[1]);
        else if (operation.equals("delay"))
            delay(redBlackBST, parts[1], parts[2]);
        else if (operation.equals("reroute"))
            reroute(redBlackBST, parts[1], parts[2]);

    }

    // // lets make some simple code
    // public static void timeTick() {
    // }

    // // Helper function that should be able to convert increase and decrease time
    // public static void changeTime(String time, int delayInSeconds) {

    // // Seperate by :
    // String[] timeSplitted = time.split(":");
    // // Convert into int
    // int hours = Integer.parseInt(timeSplitted[0]);
    // int minutes = Integer.parseInt(timeSplitted[1]);
    // int seconds = Integer.parseInt(timeSplitted[2]);

    // // Add func that adds a zero

    // if (seconds >= 60) {
    // System.out.println(delayInSeconds / 60);
    // }

    // // Convert into string again
    // String output = hours + ":" + minutes + ":" + seconds;
    // System.out.println(output);

    // }

}
