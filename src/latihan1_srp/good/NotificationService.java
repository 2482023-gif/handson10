package latihan1_srp.good;

public class NotificationService {
    private final MessageValidator validator;
    private final MessageFormatter formatter;
    private final EmailSender emailSender;
    private final SmsSender smsSender;
    private final NotificationLogger logger;
    private final NotificationRepository repository;

    public NotificationService(
            MessageValidator validator,
            MessageFormatter formatter,
            EmailSender emailSender,
            SmsSender smsSender,
            NotificationLogger logger,
            NotificationRepository repository
    ) {
        this.validator = validator;
        this.formatter = formatter;
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.logger = logger;
        this.repository = repository;
    }

    public void sendNotification(String message, String type, String recipient) {
        // 1. validate
        if (!validator.validate(recipient, message)) {
            logger.logError("Validation failed for recipient: " + recipient);
            return;
        }

        // 2. format
        String formatted = formatter.format(message);

        // 3. send according to type
        if ("EMAIL".equalsIgnoreCase(type)) {
            emailSender.send(recipient, formatted);
        } else if ("SMS".equalsIgnoreCase(type)) {
            smsSender.send(recipient, formatted);
        } else {
            logger.logError("Unknown notification type: " + type);
            return;
        }

        // 4. persist
        repository.save(type, recipient, formatted);

        // 5. log
        logger.log(type, recipient);
    }
}
