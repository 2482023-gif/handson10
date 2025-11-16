package latihan3_lsp.bad;

/**
 * Bad contract: send returns boolean, but implementations may throw,
 * which violates LSP when used polymorphically.
 */
public interface NotificationSender {
    /**
     * Send message. Return true if sent, false otherwise.
     */
    boolean send(String recipient, String message);
}
