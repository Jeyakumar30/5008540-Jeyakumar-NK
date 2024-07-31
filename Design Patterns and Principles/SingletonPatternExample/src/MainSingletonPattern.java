public class MainSingletonPattern {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // System.out.println(logger1);
        // System.out.println(logger2);
            
        if (logger1 == logger2) {
            System.out.println("Logger has a single instance.");
        } else {
            System.out.println("Logger has multiple instances.");
        }
    }
}