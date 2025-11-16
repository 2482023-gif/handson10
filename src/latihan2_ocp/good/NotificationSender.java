package latihan2_ocp.good;

/**
 * Contract untuk setiap channel pengiriman.
 * Implementor harus mengembalikan sebuah identifier tipe channel
 * dan menyediakan mekanisme send.
 */
public interface NotificationSender {

    /**
     * Identifier tipe channel, misal "EMAIL", "SMS", "WHATSAPP"
     * @return channel id
     */
    String getType();

    /**
     * Kirim pesan ke recipient.
     * Implementasi boleh melempar Exception jika terjadi kegagalan.
     * @param recipient alamat tujuan (email or phone number)
     * @param message isi pesan
     * @throws Exception jika gagal
     */
    void send(String recipient, String message) throws Exception;
}
