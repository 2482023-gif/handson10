package latihan1_srp.bad;

public class NotificationService {

    // Simulasi: method all-in-one yang melanggar SRP
    public void sendNotification(String message, String type, String recipient) {
        // 1. Validation
        if (recipient == null || recipient.isEmpty()) {
            System.out.println("[BAD] Recipient invalid: " + recipient);
            return;
        }
        if (message == null || message.isEmpty()) {
            System.out.println("[BAD] Message empty");
            return;
        }

        // 2. Formatting
        String formatted = formatMessage(message);

        // 3. Sending (both email and sms handled here)
        if ("EMAIL".equalsIgnoreCase(type)) {
            sendEmail(recipient, formatted);
        } else if ("SMS".equalsIgnoreCase(type)) {
            sendSms(recipient, formatted);
        } else {
            System.out.println("[BAD] Unknown type: " + type);
        }

        // 4. Logging
        System.out.println("[BAD][LOG] Notification sent - Type: " + type + ", Recipient: " + recipient);

        // 5. Persisting to DB (simulated)
        saveToDatabase(type, recipient, formatted);
    }

    // helper - formatting
    private String formatMessage(String message) {
        long ts = System.currentTimeMillis();
        return message.toUpperCase() + " [SENT AT: " + ts + "]";
    }

    // helper - send email
    private void sendEmail(String email, String content) {
        System.out.println("[BAD][EMAIL] Sending EMAIL to: " + email);
        System.out.println("[BAD][EMAIL] Content: " + content);
        // imagine here real SMTP logic — but mixed into same class
    }

    // helper - send sms
    private void sendSms(String phone, String content) {
        System.out.println("[BAD][SMS] Sending SMS to: " + phone);
        System.out.println("[BAD][SMS] Content: " + content);
        // imagine here real SMS gateway logic
    }

    // helper - save to "database"
    private void saveToDatabase(String type, String recipient, String content) {
        System.out.println("[BAD][DB] Saving notification record: type=" + type + ", recipient=" + recipient);
        // imagine JDBC or ORM calls here — again, inside same class
    }
}
