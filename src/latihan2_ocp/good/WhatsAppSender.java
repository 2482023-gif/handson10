package latihan2_ocp.good;

public class WhatsAppSender implements NotificationSender {

    @Override
    public String getType() {
        return "WHATSAPP";
    }

    @Override
    public void send(String recipient, String message) throws Exception {
        // Stub: integrasi dengan WhatsApp Business API di produksi
        System.out.printf("[WhatsApp] Sending to: %s | Content: %s%n", recipient, message);
    }
}
