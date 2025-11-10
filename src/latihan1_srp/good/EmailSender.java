package latihan1_srp.good;

public class EmailSender {
    // Single responsibility: send email only
    public void send(String recipient, String message) {
        // Simulasi: print ke console
        System.out.println("[EmailSender] Sending EMAIL to: " + recipient);
        System.out.println("[EmailSender] Content: " + message);
        // In real app: use SMTP client or library
    }
}
