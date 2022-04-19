import edu.princeton.cs.algs4.RedBlackBST;
import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        RedBlackBST redBlackBST = new RedBlackBST<>();
        Stack stack = new Stack<>();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int i = 1;

        // For testing ...
        // String x = "09:00:00 Chicago";
        // String[] sepLine2 = x.split(" ");
        // System.out.println(Integer.parseInt(sepLine2[0]));
        // System.out.println(sepLine2[1]);

        while (i < (n + 1)) {
            var line = s.nextLine();
            String[] sepLine = s.nextLine().split("\\s+");
            redBlackBST.put((sepLine[0]), sepLine[1]);
            i++;
        }

        int j = 1;
        while (j < (m + 1)) {
            stack.add(s.nextLine());
            j++;
        }
        s.close();
    }

    // 14 10
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

}
