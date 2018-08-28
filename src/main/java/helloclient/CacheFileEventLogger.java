package helloclient;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache;

    private CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize=cacheSize;
        this.cache=new ArrayList<>();
    }


    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if(cache.size()==cacheSize){
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache(){
        for (Event event :cache
             ) {
            super.logEvent(event);
        }
        cache.clear();
    }

    private void destroy(){
        if (!cache.isEmpty()){
            writeEventsFromCache();
        }
    }
}
