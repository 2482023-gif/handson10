package latihan3_lsp;

public class LSPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 3: LISKOV SUBSTITUTION PRINCIPLE (LSP)
         * Demo BAD (violation) and GOOD (compliant).
         */

        // ===== PART 1: BAD PRACTICE - Melanggar LSP =====
        System.out.println("=== BAD PRACTICE: Melanggar LSP ===\n");

        // Polymorphic references to parent interface (bad)
        latihan3_lsp.bad.NotificationSender badEmail = new latihan3_lsp.bad.EmailSender();
        latihan3_lsp.bad.NotificationSender readOnly = new latihan3_lsp.bad.ReadOnlySender(); // PROBLEM

        System.out.println("Testing EmailSender (bad):");
        processBadNotification(badEmail, "user@example.com", "Hello from bad email");

        System.out.println("\nTesting ReadOnlySender (bad):");
        try {
            processBadNotification(readOnly, "user@example.com", "Hello from readOnly");
        } catch (RuntimeException e) {
            System.out.println("❌ Exception thrown: " + e.getClass().getSimpleName() + ": " + e.getMessage());
            System.out.println("❌ Program crashed!");
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("ReadOnlySender melanggar LSP karena:");
        System.out.println("1. Parent NotificationSender promise: bisa send notification");
        System.out.println("2. ReadOnlySender: throw exception instead");
        System.out.println("3. Cannot substitute parent class safely");
        System.out.println("4. Breaks polymorphic code");
        System.out.println("\nIni MELANGGAR LSP: subclass tidak bisa replace parent!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti LSP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti LSP ===\n");

        // Use good implementations (abstract base class + implementations that follow contract)
        latihan3_lsp.good.NotificationSender goodEmail = new latihan3_lsp.good.EmailSender();
        latihan3_lsp.good.NotificationSender goodSms = new latihan3_lsp.good.SmsSender();

        System.out.println("Testing good EmailSender:");
        testGoodSender(goodEmail, "user@example.com", "Hello from good email");

        System.out.println("Testing good SmsSender:");
        testGoodSender(goodSms, "081234567890", "Hello from good sms");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Predictable - Semua child class berperilaku sesuai ekspektasi");
        System.out.println("✓ Reliable - Tidak ada surprise behavior");
        System.out.println("✓ Interchangeable - Bisa ganti child class dengan aman");
        System.out.println("✓ Safe - Polymorphic code bekerja tanpa masalah");
    }

    // helper for bad package (uses bad.NotificationSender)
    private static void processBadNotification(latihan3_lsp.bad.NotificationSender sender,
                                               String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("✓ Notification sent successfully");
        } else {
            System.out.println("✗ Failed to send notification");
        }
    }

    // helper for good package (uses good.NotificationSender)
    private static void testGoodSender(latihan3_lsp.good.NotificationSender sender,
                                       String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("  → Success!");
        } else {
            System.out.println("  → Failed!");
        }
    }
}
