package latihan3_lsp.good;

public class SmsSender extends NotificationSender {

    @Override
    protected boolean doSend(String recipient, String message) {
        // Simulate SMS sending
        System.out.printf("[Sms] ✓ Notification sent to: %s%n", recipient);
        return true;
    }
}
