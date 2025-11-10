package latihan1_srp.good;

public class MessageFormatter {
    // Adds timestamp and uppercases (example)
    public String format(String message) {
        long ts = System.currentTimeMillis();
        String formatted = message.toUpperCase() + " [SENT AT: " + ts + "]";
        System.out.println("[Formatter] Message formatted: " + formatted);
        return formatted;
    }
}
