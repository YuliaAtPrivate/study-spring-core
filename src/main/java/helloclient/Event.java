package helloclient;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat df){
        this.date = date;
        this.id = ThreadLocalRandom.current().nextInt(0, 1000);
        this.dateFormat = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public static boolean isDay(int add){
        LocalTime time = LocalTime.now().plusHours(add);
//        LocalTime time = LocalTime.now();
        return time.isAfter(LocalTime.of(12,0)) && time.isBefore(LocalTime.of(18,0));
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
