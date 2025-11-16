package latihan2_ocp.good;

public class SmsSender implements NotificationSender {

    @Override
    public String getType() {
        return "SMS";
    }

    @Override
    public void send(String recipient, String message) throws Exception {
        // Stub: integrasikan provider SMS API (HTTP) di produksi
        System.out.printf("[SMS] Sending to: %s | Content: %s%n", recipient, message);
    }
}
