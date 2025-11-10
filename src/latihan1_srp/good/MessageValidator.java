package latihan1_srp.good;

public class MessageValidator {
    // Validates recipient + message (simple rules)
    public boolean validate(String recipient, String message) {
        if (recipient == null || recipient.isEmpty()) {
            System.out.println("[Validator] Recipient invalid");
            return false;
        }
        if (message == null || message.isEmpty()) {
            System.out.println("[Validator] Message empty");
            return false;
        }
        // could add more checks: valid email format, phone number format, length, etc.
        System.out.println("[Validator] Message validated successfully");
        return true;
    }
}
