import java.util.Scanner;

public class MainDecoratorPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message to send: ");
        String message = sc.nextLine();

        Notifier emailNotifier = new EmailNotifier();
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackSMSNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        slackSMSNotifier.send(message);

        sc.close();
    }
}