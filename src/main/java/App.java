public class App {
    private Client client;
    private EventLogger eventLogger;

public App(Client client, EventLogger eventLogger){
    this.client = client;
    this.eventLogger = eventLogger;
}
    public static void main(String[] args) {
        App app = new App(new Client("1", "Foo bar"), new ConsoleEventLogger());
        app.logEvent("Message for my favorite client: 11");
    }

    private void logEvent(String msg){
        eventLogger.logEvent(msg.replaceAll(client.getId(), client.getFullName()));
    }
}
