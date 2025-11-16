package latihan2_ocp.bad;

/**
 * Contoh buruk: if-else chain untuk memilih channel.
 * Setiap kali mau tambah channel baru, kita harus modify class ini.
 */
public class NotificationService {

    /**
     * Mengirim notification ke recipient menggunakan channel yang diberikan.
     * @param message isi pesan
     * @param channel tipe channel, mis. "EMAIL", "SMS", "WHATSAPP"
     * @param recipient alamat atau nomor tujuan
     */
    public void sendNotification(String message, String channel, String recipient) {
        if (channel == null) {
            throw new IllegalArgumentException("Channel tidak boleh null");
        }

        if ("EMAIL".equalsIgnoreCase(channel)) {
            // logika pengiriman email (stub)
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + message);
        } else if ("SMS".equalsIgnoreCase(channel)) {
            // logika pengiriman sms (stub)
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + message);
        } else if ("PUSH".equalsIgnoreCase(channel)) {
            // contoh channel lain
            System.out.println("Sending PUSH to: " + recipient);
            System.out.println("Content: " + message);
        } else {
            // Jika ingin menambah WHATSAPP, harus tambahkan else-if di sini -> melanggar OCP
            System.out.println("Unknown channel: " + channel + ". Cannot send message.");
        }
    }
}
