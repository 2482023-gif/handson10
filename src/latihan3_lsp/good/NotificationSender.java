package latihan3_lsp.good;

/**
 * Good abstraction that enforces a clear contract:
 * - Precondition: recipient and message must not be null (caller responsibility).
 * - Postcondition: method returns true if send succeeded, false on failure.
 * - Implementations MUST NOT throw runtime exceptions for normal failure cases.
 *
 * We use an abstract class with a final send() to allow a template pattern
 * (validate inputs centrally) and defer actual sending to doSend().
 */
public abstract class NotificationSender {

    /**
     * Final send method enforces precondition check and wraps implementation.
     * Implementations should implement doSend and return boolean, never throw.
     */
    public final boolean send(String recipient, String message) {
        if (recipient == null || message == null) {
            // precondition violation: treat as failure (do not throw)
            return false;
        }
        try {
            return doSend(recipient, message);
        } catch (RuntimeException e) {
            // Defensive: implementations should not throw, but if they do,
            // we catch and translate to failure to preserve contract.
            System.err.println("Implementation threw runtime exception: " + e.getMessage());
            return false;
        }
    }

    /**
     * Subclasses provide concrete sending logic here.
     * Must return true on success or false on failure. MUST NOT throw.
     */
    protected abstract boolean doSend(String recipient, String message);
}
