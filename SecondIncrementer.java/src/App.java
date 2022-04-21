public class App {
    public static void main(String[] args) throws Exception {

        Clock clock = new Clock(0, 0, 0);

        boolean debug = false;

        if (debug) {
            // excected 0:10:6 - works
            clock.delayBySeconds(606);
            System.out.println(clock.toString());
            clock.reset();

            // excected 0:36:38 - works
            clock.delayBySeconds(2198);
            System.out.println(clock.toString());
            clock.reset();

            // excected 0:59:59 - works
            clock.delayBySeconds(3599);
            System.out.println(clock.toString());
            clock.reset();

            // excected 01:08:00 - works
            clock.delayBySeconds(4080);
            System.out.println(clock.toString());
            clock.reset();

            // excected 01:08:33 - works
            clock.delayBySeconds(4113);
            System.out.println(clock.toString());
            clock.reset();

            // Prep
            clock.delayBySeconds(79200);
            // excected 02:00:00 - works
            clock.delayBySeconds(14400);
            System.out.println(clock.toString());
            clock.reset();

            // excected 02:38:42 - works
            clock.delayBySeconds(95922);
            System.out.println(clock.toString());
            clock.reset();
        }
    }
}