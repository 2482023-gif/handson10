package latihan1_srp.good;

public class NotificationRepository {
    public void save(String type, String recipient, String message) {
        // Simulasi penyimpanan
        System.out.println("[Repository] DB: Saving notification record - type=" + type + ", recipient=" + recipient);
        // In real app: use JDBC, JPA, or other persistence mechanism
    }
}
