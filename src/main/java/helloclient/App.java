package helloclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Event event;
    private Event clientEvent;

    public App(Client client, EventLogger eventLogger, Event event){
        this.client = client;
        this.eventLogger = eventLogger;
        this.event=event;
        this.clientEvent=new Event(event.getDate(), event.getDateFormat());
        clientEvent.setMsg(client.toString());
        System.out.println(this.clientEvent);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("parentApp.xml");
        App app = (App) ctx.getBean("app");
        app.event.setMsg("Бакунина, 55");
       // app.clientEvent.setMsg(app.client.toString());
        app.logEvent(app.event);
        app.logEvent(app.clientEvent);
        app.logEvent(app.event);
        app.logEvent(app.event);
        ctx.close();

    }

    private void logEvent(Event event){
        eventLogger.logEvent(event);
    }
}
