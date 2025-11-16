package latihan3_lsp.bad;

/**
 * BAD: a subclass that breaks LSP by throwing an exception instead of
 * honoring the parent contract.
 */
public class ReadOnlySender implements NotificationSender {

    @Override
    public boolean send(String recipient, String message) {
        // This violates the contract: instead of returning false, it throws.
        throw new UnsupportedOperationException("This sender is read-only!");
    }
}
