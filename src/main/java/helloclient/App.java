package helloclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Map<EventType,EventLogger> eventLoggers;
    private Event event;
    private Event clientEvent;
    private EventType eventType;

    public App(Client client, Map<EventType, EventLogger> eventLoggers, Event event, EventType eventType){
        this.event=event;
        this.eventLoggers=eventLoggers;
        this.clientEvent=new Event(event.getDate(), event.getDateFormat());
        clientEvent.setMsg(client.toString());
        this.eventType=eventType;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("parentApp.xml");
        App app = (App) ctx.getBean("app");
        app.event.setMsg("Бакунина, 55");
        app.logEvent(app.event, app.eventType);
        app.logEvent(app.clientEvent, app.eventType);
        app.logEvent(app.event, app.eventType);
        app.logEvent(app.event, app.eventType);
        ctx.close();

    }

    private void logEvent(Event event, EventType eventType){
        EventLogger logger = eventLoggers.get(eventType);
        if(logger==null) logger = eventLoggers.get(EventType.DEFAULT);
        logger.logEvent(event);
    }
}
