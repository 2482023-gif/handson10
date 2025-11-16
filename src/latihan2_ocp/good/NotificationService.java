package latihan2_ocp.good;

import java.util.List;
import java.util.Objects;

/**
 * Good NotificationService: menerima list implementor NotificationSender.
 * Tidak perlu diubah ketika menambah channel baru — cukup tambahkan implementor baru.
 */
public class NotificationService {

    private final List<NotificationSender> senders;

    /**
     * Constructor injection — memudahkan testing dan konfigurasi.
     * @param senders daftar implementasi NotificationSender
     */
    public NotificationService(List<NotificationSender> senders) {
        this.senders = Objects.requireNonNull(senders, "senders tidak boleh null");
    }

    /**
     * Mengirim pesan ke semua channel yang terdaftar (broadcast).
     * @param message isi pesan
     * @param recipient tujuan (mis. email or phone)
     */
    public void sendNotification(String message, String recipient) {
        for (NotificationSender sender : senders) {
            try {
                sender.send(recipient, message);
            } catch (Exception e) {
                // Kebijakan penanganan error: log dan lanjutkan ke sender berikutnya (best-effort)
                System.err.printf("Failed to send via %s: %s%n", sender.getType(), e.getMessage());
            }
        }
    }

    /**
     * Kirim hanya ke channel tertentu
     * @param message isi
     * @param recipient tujuan
     * @param channelType channel yang diinginkan, mis. "SMS"
     */
    public void sendNotificationToChannel(String message, String recipient, String channelType) {
        for (NotificationSender sender : senders) {
            if (sender.getType().equalsIgnoreCase(channelType)) {
                try {
                    sender.send(recipient, message);
                } catch (Exception e) {
                    System.err.printf("Failed to send via %s: %s%n", sender.getType(), e.getMessage());
                }
                return;
            }
        }
        System.out.println("No sender found for channel: " + channelType);
    }
}
