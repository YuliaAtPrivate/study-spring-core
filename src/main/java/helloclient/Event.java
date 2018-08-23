package helloclient;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Event {
    private int id;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat df){
        this.date = date;
        this.id = ThreadLocalRandom.current().nextInt(0, 1000);
        this.dateFormat = df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
