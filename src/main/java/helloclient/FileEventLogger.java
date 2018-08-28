package helloclient;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    FileEventLogger(String fileName){
        this.fileName=fileName;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(FileUtils.getFile(fileName), event.toString() + "\n",
                    Charset.defaultCharset(), true);
            System.out.println("ADDED IT TO LOG FILE");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException{
        this.file = new File(fileName);
//        file.setWritable(true);
        if (!file.canWrite()){
            throw new IOException("Can't write to file!! Help!");
        }
    }
}
