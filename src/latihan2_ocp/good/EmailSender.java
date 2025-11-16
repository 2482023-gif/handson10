package latihan2_ocp.good;

public class EmailSender implements NotificationSender {

    @Override
    public String getType() {
        return "EMAIL";
    }

    @Override
    public void send(String recipient, String message) throws Exception {
        // Stub: integrasikan JavaMail atau library email lain di produksi
        System.out.printf("[EMAIL] Sending to: %s | Content: %s%n", recipient, message);
    }
}
