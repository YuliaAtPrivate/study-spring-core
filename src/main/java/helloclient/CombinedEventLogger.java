package helloclient;

public class CombinedEventLogger implements EventLogger
{
    private EventLogger[] loggers;

    public CombinedEventLogger(EventLogger[] loggers){
        this.loggers=loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger: loggers
             ) {
            logger.logEvent(event);
        }
    }
}
