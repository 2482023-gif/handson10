package latihan1_srp.good;

public class NotificationLogger {
    public void log(String type, String recipient) {
        System.out.println("[Logger] LOG: Notification sent - Type: " + type + ", Recipient: " + recipient);
    }

    public void logError(String info) {
        System.out.println("[Logger] ERROR: " + info);
    }
}
