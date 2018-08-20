public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client("1", "John Dohn");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Message for my favorite client: 11");
    }

    private void logEvent(String msg){
        eventLogger.logEvent(msg.replaceAll(client.getId(), client.getFullName()));
    }
}
