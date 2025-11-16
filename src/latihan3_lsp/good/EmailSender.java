package latihan3_lsp.good;

public class EmailSender extends NotificationSender {

    @Override
    protected boolean doSend(String recipient, String message) {
        // Simulate email sending
        System.out.printf("[Email] ✓ Notification sent to: %s%n", recipient);
        return true;
    }
}
