package latihan1_srp.good;

public class SmsSender {
    // Single responsibility: send sms only
    public void send(String recipient, String message) {
        // Simulasi: print ke console
        System.out.println("[SmsSender] Sending SMS to: " + recipient);
        System.out.println("[SmsSender] Content: " + message);
        // In real app: call SMS gateway API
    }
}
