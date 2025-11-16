package latihan3_lsp.bad;

public class EmailSender implements NotificationSender {

    @Override
    public boolean send(String recipient, String message) {
        // Simulate successful sending
        System.out.printf("✓ Notification sent via EMAIL to %s%n", recipient);
        return true;
    }
}
