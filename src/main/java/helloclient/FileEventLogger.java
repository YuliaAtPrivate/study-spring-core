package helloclient;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    private FileEventLogger(String fileName){
        this.fileName=fileName;
    }

    @Override
    public void logEvent(Event event) {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileUtils.writeStringToFile(FileUtils.getFile(fileName), event.toString() + "\n", true);
            System.out.println("ADDED IT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException{
        this.file = new File(fileName);
        if (!file.canWrite()){
            throw new IOException("Can't write to file!! Help!");
        }
    }
}
