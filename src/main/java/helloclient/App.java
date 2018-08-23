package helloclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Event event;

    public App(Client client, EventLogger eventLogger, Event event){
        this.client = client;
        this.eventLogger = eventLogger;
        this.event=event;
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.event.setMsg("vvпр. Бакунина, 5");
        app.logEvent(app.event);
    }

    private void logEvent(Event event){
        eventLogger.logEvent(event);
    }
}
