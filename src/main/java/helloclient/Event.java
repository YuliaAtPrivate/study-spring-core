package helloclient;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Event {
    private int id;
    private String msg;
    private Date date;

    public Event(Date date){
        this.date = date;
        this.id = ThreadLocalRandom.current().nextInt(0, 1000);
    }
}
